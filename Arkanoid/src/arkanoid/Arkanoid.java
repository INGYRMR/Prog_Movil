package arkanoid;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Nombre del alumno: MERCADO ROMERO YAHIR RICARDO
 * Grupo: 2807
 */
public class Arkanoid extends JPanel implements MouseMotionListener, ActionListener {
    Timer timer;
    int ballX = 250;
    int ballY = 250;
    int ballWidth = 10;
    int ballHeight = 10;
    int ballVelX = 2;
    int ballVelY = 2;
    int paddleX = 200;
    int paddleY = 500;
    int paddleWidth = 150;
    int paddleHeight = 40;

    Rectangle[][] blocks;
    int blockWidth = 60;
    int blockHeight = 20;
    int rows = 4, cols = 6;
    boolean inRunnig = true;
    boolean isGameOver = false;
    boolean isGameWon = false;

    public Arkanoid() {
        setBackground(Color.BLACK);
        addMouseMotionListener(this);

        blocks = new Rectangle[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                blocks[i][j] = new Rectangle(j * (blockWidth + 10) + 30, i * (blockHeight + 5) + 30, blockWidth, blockHeight);
            }
        }
        timer = new Timer(5, this);
        timer.start();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        paddleX = e.getX() - paddleWidth / 2;
        if (paddleX < 0) paddleX = 0;
        if (paddleX > getWidth() - paddleWidth) paddleX = getWidth() - paddleWidth;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isGameOver || isGameWon) {
            return;
        }

        ballX += ballVelX;
        ballY += ballVelY;

        if (ballX <= 0 || ballX >= getWidth() - 10) {
            ballVelX = -ballVelX;
        }
        if (ballY <= 0) {
            ballVelY = -ballVelY;
        }

        if (ballY >= getHeight()) {
            isGameOver = true;
        }

        Rectangle ballRect = new Rectangle(ballX, ballY, 10, 10);
        Rectangle paddleRect = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
        if (ballRect.intersects(paddleRect)) {
            ballVelY = -ballVelY;
            ballY = paddleY - 10;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (blocks[i][j] != null && blocks[i][j].intersects(new Rectangle(ballX, ballY, 10, 10))) {
                    ballVelY = -ballVelY;
                    blocks[i][j] = null;
                }
            }
        }
        
        boolean blocksLeft = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (blocks[i][j] != null) {
                    blocksLeft = true;
                    break;
                }
            }
        }
        if (!blocksLeft) {
            isGameWon = true;
            timer.stop();
        }
        repaint();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillOval(ballX, ballY, ballWidth, ballHeight);

        g.setColor(Color.yellow);
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);

        g.setColor(Color.green);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (blocks[i][j] != null) {
                    g.fillRect(blocks[i][j].x, blocks[i][j].y, blockWidth, blockHeight);
                }
            }
        }

        if (isGameOver) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", getWidth() / 2 - 100, getHeight() / 2);
        }

        if (isGameWon) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("¡Ganaste!", getWidth() / 2 - 80, getHeight() / 2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Arkanoid Game");
        Arkanoid ag = new Arkanoid();
        frame.add(ag);
        frame.setSize(480, 600);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {}
}
