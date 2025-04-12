package paint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * Nombre del alumno: MERCADO ROMERO YAHIR RICARDO
 * Grupo: 2807
 */
public class Paint extends JFrame {
    JComboBox<String> comboColores;
    JButton btnLimpiar;
    DibujoPanel panelDibujo;
    Color colorSeleccionado = Color.BLACK;

    public Paint(){
        setTitle("Mi Paint");
        setSize(400,400);
        setDefaultCloseOperation(3);

        String[] colores = {"Negro", "Rojo", "Azul"};
        comboColores = new JComboBox<>(colores);

        comboColores.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String colorSeleccionadoTexto = (String)comboColores.getSelectedItem();
                switch(colorSeleccionadoTexto){
                    case "Rojo":
                        colorSeleccionado = Color.RED;
                        break;
                    case "Azul":
                        colorSeleccionado = Color.BLUE;
                        break;
                    case "Negro":
                    default:
                        colorSeleccionado = Color.BLACK;
                        break;
                }
            }
        });
        panelDibujo = new DibujoPanel();
        JPanel panel01 = new JPanel();
        panel01.add(comboColores);
        add(panel01, BorderLayout.NORTH);
        add(panelDibujo, BorderLayout.CENTER);
    }
    class DibujoPanel extends JPanel {
        ArrayList<Point> puntos = new ArrayList<>();
        public DibujoPanel() {
            setBackground(Color.WHITE);
            addMouseMotionListener(new MouseAdapter(){
                @Override
                public void mouseDragged(MouseEvent e){
                    puntos.add(e.getPoint());
                    repaint();
                }
            });
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(colorSeleccionado);
            for(Point punto: puntos){
                g.fillOval(punto.x, punto.y, 5, 5);
            }
        }
        public void limpiar(){
            puntos.clear();
            repaint();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Paint().setVisible(true);
            }
        });
    }
}
