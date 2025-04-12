package programa4;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Nombre del alumno: MERCADO ROMERO YAHIR RICARDO
 * Grupo: 2807
 */
public class Programa4 implements ActionListener{
    JLabel etiquetaContador;
    JButton btnIniciar, btnReiniciar;
    int contador;
    boolean btnActivo = false;
    Hilo hc;
    public Programa4(){
        JFrame ventana = new JFrame();
        ventana.setTitle("Cronometro");
        ventana.setSize(300,300);
        JPanel p = new JPanel(new GridLayout(3,1));
        
        etiquetaContador = new JLabel("0.00");
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.addActionListener(this);
        
        p.add(etiquetaContador);
        p.add(btnIniciar);
        p.add(btnReiniciar);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.add(p);
    }
    public static void main(String[] args) {
        Programa4 prueba = new Programa4();
    }
    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource().equals(btnIniciar)){
            btnActivo = true;
            hc = new Hilo();
            hc.start();
        }
        if(e.getSource().equals(btnReiniciar)){
            btnActivo = false;
            contador = 0;
            etiquetaContador.setText("0.00");
        }
    }
    private class Hilo extends Thread{
        public void run(){
            while (true){
                try{
                    if(btnActivo){
                        contador++;
                        double tiempo = contador / 100.0;
                        etiquetaContador.setText(String.format("%.2f",tiempo));
                        Thread.sleep(10);
                    }
                }
                catch(Exception e){
                }
            }
        }
    }
}
