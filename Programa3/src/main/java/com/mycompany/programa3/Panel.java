package com.mycompany.programa3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Nombre del alumno: MERCADO ROMERO YAHIR RICARDO
 * Grupo: 2807
 */
public class Panel extends JPanel implements MouseMotionListener, MouseListener{
    int x = 100;
    int y = 100;
    
    JLabel labelCoordenadas;
    JLabel labelGanaste;
    boolean arrastrando = false;
    
    public Panel(JLabel labelCoordenadas, JLabel labelGanaste){
        this.labelCoordenadas = labelCoordenadas;
        this.labelGanaste = labelGanaste;
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(arrastrando){
            g.setColor(Color.red);
        }else{
            g.setColor(Color.green);
        }
        g.fillOval(x, y, 30, 30); 
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        labelCoordenadas.setText("x= " + x + "y= " +y );
        if(x == 100 && y == 100){
            labelGanaste.setText("Ganaste mi rey");
        }else{
            labelGanaste.setText(" ");
        }
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
     @Override
    public void mousePressed(MouseEvent e) {
        arrastrando = true;
        repaint(); 
    }
    
      @Override
    public void mouseReleased(MouseEvent e) {
        arrastrando = false;
        repaint(); 
    }
    
     @Override
    public void mouseEntered(MouseEvent e) {
  
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
  
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
  
    } 
}
