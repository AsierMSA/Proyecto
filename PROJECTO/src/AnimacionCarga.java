import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class AnimacionCarga {
    public static void main(Usuario u) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear la ventana de carga
                JFrame loading = new JFrame("Animación de carga");
                loading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JLabel label = new JLabel("Cargando...");
                JProgressBar pb = new JProgressBar();
                pb.setStringPainted(true);
                pb.setValue(0);
                loading.add(label);
                loading.add(pb);
                loading.pack();
                loading.setVisible(true);
                System.out.println(u);
				MENU.setUactual(u);

           
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                    	MENU m = null;
						try {
							m = new MENU(u);
							MENU.frame.setVisible(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    					
                    }
                });
                thread.start();
               
               
                Timer timer = new Timer(50, new ActionListener() {
                    int progress = 0;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      pb.setValue(progress);
                      progress++;
                      if(progress == 100) {
                         loading.setVisible(false);
                         
                      }
                    }
                });
                timer.start();
            }
        });
    }
}
