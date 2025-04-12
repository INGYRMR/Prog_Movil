package com.mycompany.programa3;
import javax.swing.*;
import java.awt.*;


/**
 * Nombre del alumno: MERCADO ROMERO YAHIR RICARDO
 * Grupo: 2807
 */
public class Programa3 extends JFrame{
    private Panel panelBolita;
    private JPanel panelInfo;
    private JPanel panelGanaste;
    private JLabel coordenadas;
    private JLabel ganaste;
    
    public Programa3(){
        setTitle("Bolita 01");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelInfo = new JPanel();
        coordenadas = new JLabel("x=100 y=100");
        panelInfo.add(coordenadas); 
        
        panelGanaste = new JPanel();
        ganaste = new JLabel("No");
        panelGanaste.add(ganaste); 
        
        panelBolita = new Panel(coordenadas, ganaste);
        add(panelInfo, BorderLayout.NORTH);
        add(panelBolita, BorderLayout.CENTER);
        add(panelGanaste, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        
        Programa3 ventana = new Programa3();
        ventana.setVisible(true);
    }
}
