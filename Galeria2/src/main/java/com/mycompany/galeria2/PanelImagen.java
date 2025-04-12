package com.mycompany.galeria2;

import javax.swing.*;
import java.awt.*;

/**
 *
 * MERCADO ROMERO YAHIR RICARDO
 * GRUPO: 2807
 */
public class PanelImagen extends JPanel{
    Image imagenDada;
    
    public void setImagen(String ruta){
        String path = "src/main/java/com/mycompany/galeria2/" + ruta;
        System.out.println("Cargando imagen desde: " + path); 
        
        imagenDada = Toolkit.getDefaultToolkit().getImage(path);

        repaint();
    }
 
 @Override 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagenDada != null){
            
        }
        g.drawImage(imagenDada, 1, 1, getWidth(), getHeight(), this);
    }
}
