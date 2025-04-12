package com.mycompany.programa1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * MERCADO ROMERO YAHIR RICARDO
 * GRUPO: 2807
 */
public class Programa1 extends JFrame implements ActionListener{
    JLabel texto;
    JTextField textoDado;
    JButton btnSaludar;
    
    public Programa1(){
        setSize(400, 400);
        setTitle("Programa 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        texto = new JLabel("Ingresa tu nombre: ");
        textoDado = new JTextField();
        btnSaludar =  new JButton ("Saludar");
        btnSaludar.addActionListener(this);
        add(texto, BorderLayout.NORTH);
        add(btnSaludar, BorderLayout.SOUTH);
        add(textoDado, BorderLayout.CENTER);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
       String nombre = textoDado.getText();
       textoDado.setText("Hola "+nombre);
    }

    public static void main(String[] args) {
        Programa1 prueba = new Programa1();
        prueba.setVisible(true);
    }
}



