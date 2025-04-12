package com.mycompany.calculadora;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * MERCADO ROMERO YAHIR RICARDO
 * GRUPO: 2807
 */
public class Calculadora extends JFrame implements ActionListener{
    JTextField pantalla; 
    JButton botones[];
    String op1 , op2 ;
    boolean vsuma, vresta, vmulti, vdiv, vpunto;
    double resultado;
    
    public Calculadora(){
        setSize(400, 600);
        setTitle("Casio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        Font f = new Font("Arial", Font.BOLD,70);
        
        pantalla = new JTextField();
        pantalla.setBounds(1, 20, 380, 80);
        pantalla.setEditable(false);
        pantalla.setFont(f);
        pantalla.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(pantalla);
        
        int x = 10;
        int y = 420;
        botones = new JButton[17];
        botones[0] = new JButton("0");
        botones[0].setBounds(x, y, 80, 80);
        botones[0].setFont(f);
        botones[0].addActionListener(this);
        add(botones[0]);
        y = 320;
        
        int contador = 1;
        for(int i=1; i<10; i++){
             botones[i] = new JButton(i+"");
             botones[i].setBounds(x, y, 80, 80);
             botones[i].setFont(f);
             botones[i].addActionListener(this);
             add(botones[i]);
             x = x+100;
             if(contador==3){
                 y = y-100;
                 x = 1;
                 contador = 0;
             }
             contador = contador+1;
        }
        
        botones[10] = new JButton("+");
        botones[10].setBounds(301, 120, 80, 80);
        botones[10].setFont(f);
        botones[10].addActionListener(new ActionListener() {
       @Override
        public void actionPerformed(ActionEvent e) {
                op1 = pantalla.getText();
                pantalla.setText(" ");
                operaciones();
                vsuma= true;
                vpunto = true;
            }
        });
        add(botones[10]);
        
        botones[11] = new JButton("=");
        botones[11].setBounds(201, 420, 80, 80);
        botones[11].setFont(f);
        botones[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op2 = pantalla.getText();
                if(vsuma){
                    resultado = Double.parseDouble(op1) + Double.parseDouble(op2);
                    vsuma = false;
                }
                if(vresta){
                    resultado = Double.parseDouble(op1) - Double.parseDouble(op2);
                    vresta = false;
                }
                if(vmulti){
                    resultado = Double.parseDouble(op1) * Double.parseDouble(op2);
                    vmulti = false;
                }
                if(vdiv){
                    if(Double.parseDouble(op2) != 0){
                        resultado = Double.parseDouble(op1) / Double.parseDouble(op2);
                    }else{
                        pantalla.setText("Error");
                        return;
                    }
                    vdiv = false;
                }
                pantalla.setText(resultado + " ");
                operaciones();
            }
        });
        add(botones[11]);
        
        botones[12] = new JButton("-");
        botones[12].setBounds(301, 220, 80, 80);
        botones[12].setFont(f);
        botones[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op1 = pantalla.getText();
                pantalla.setText(" ");
                operaciones();
                vresta= true;
                vpunto = true;
            }
        });
        add(botones[12]);
        
        botones[13] = new JButton(".");
        botones[13].setBounds(101, 420, 80, 80);
        botones[13].setFont(f);
        botones[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vpunto){
                    pantalla.setText(pantalla.getText()+".");
                    vpunto = false;
                }
            }
        });
        add(botones[13]);
        
        botones[14] = new JButton("/");
        botones[14].setBounds(301, 420, 80, 80);
        botones[14].setFont(f);
        botones[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op1 = pantalla.getText();
                pantalla.setText("");
                operaciones();
                vdiv = true;
                vpunto = true;
            }
        });
        add(botones[14]);
        
        botones[15] = new JButton("x");
        botones[15].setBounds(301, 320, 80, 80);
        botones[15].setFont(f);
        botones[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op1 = pantalla.getText();
                pantalla.setText("");
                operaciones();
                vmulti = true;
                vpunto = true;
            }
        });
        add(botones[15]);  
        
        botones[16] = new JButton("c");
        botones[16].setBounds(301,520, 80, 80);
        botones[16].setFont(f);
        botones[16].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText("");
                operaciones();
            }
        });
        add(botones[16]);   
    }
    
    private void operaciones(){
        vsuma = vresta = vdiv = vmulti = false;
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        JButton presionar = (JButton)e.getSource();
        pantalla.setText(pantalla.getText()+presionar.getText());
    }
   
    public static void main(String[] args) {
        Calculadora prueba = new Calculadora();
        prueba.setVisible(true);
    }
}
