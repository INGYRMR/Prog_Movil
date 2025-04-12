package com.mycompany.galeria2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * MERCADO ROMERO YAHIR RICARDO
 * GRUPO: 2807
 */
public class Galeria2 extends JFrame implements ActionListener{
    PanelImagen pi;
    JPanel botones;
    JButton btnAtras, btnAdelante;
    String nuevaImagen;
    int cont = 1;
    
    public Galeria2(){
        setTitle("Galería de imágenes");
        setSize(400, 400);
        setDefaultCloseOperation(3);
        
        pi = new PanelImagen();
        pi.setImagen("gato1" + cont + ".jpg");
        pi.setSize(400, 350);
        
        botones = new JPanel();
        btnAtras = new JButton("Atras");
        btnAdelante = new JButton("Adelante");
        btnAtras.addActionListener(this);
        btnAdelante.addActionListener(this);
        botones.add(btnAtras);
        botones.add(btnAdelante);
        
        add(pi, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
    }
@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnAtras)){
            if(cont <= 1){
                cont = 3;  
            }else{
                cont -= 1;
            }  
        }
        
        if(e.getSource().equals(btnAdelante)){
            if(cont >= 3){
                cont = 1;  
            }else{
                cont += 1;
            }  
        }
        
        System.out.println("Contador " +cont);
        pi.setImagen("gato" + cont + ".jpg");  
    }
    public static void main(String[] args) {
        Galeria2 prueba = new Galeria2();
        prueba.setVisible(true);
    } 
}
