import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class VentanaInicioSesion extends JFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	    private JLabel labelUsername;
	    private JLabel labelPassword;
	    private JTextField textUsername;
	    private JPasswordField textPassword;
	    private JButton buttonLogin;
	    private JButton buttonCancel;
	    private JLabel linkLabel;
	    private static HashMap<String,Usuario> usuarios=null;
	    
	    public VentanaInicioSesion() {
	        // Configurar la ventana
	        setTitle("Inicio de sesión");
	        setSize(400, 300);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        
	        panel = new JPanel();
	        panel.setLayout(null);


	        labelUsername = new JLabel("Nombre de usuario:");
	        labelUsername.setBounds(30, 50, 150, 25);
	        labelPassword = new JLabel("Contraseña:");
	        labelPassword.setBounds(30, 100, 150, 25);
	        linkLabel = new JLabel("<html><a href=''>Crear nuevo usuario</a></html>");
	        linkLabel.setBounds(30, 200, 350, 25);
	        
	     
	        textUsername = new JTextField();
	        textUsername.setBounds(200, 50, 150, 25);
	        textPassword = new JPasswordField();
	        textPassword.setBounds(200, 100, 150, 25);

	
	     buttonLogin = new JButton("Iniciar sesión");
	     buttonLogin.setBounds(100, 150, 120, 30);
	     buttonCancel = new JButton("Cancelar");
	     buttonCancel.setBounds(240, 150, 120, 30);
	     if(usuarios==null) {
             BD.cargaUsuarios();
             }

	     buttonLogin.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             String username = textUsername.getText();
	             String password = new String(textPassword.getPassword());
	             Boolean correctocon=false;
	             Boolean correctou=false;
	             Usuario correcto = null;
	             usuarios=BD.getMapaUsuarios();
	             for(Usuario u:  BD.getMapaUsuarios().values()) {
	            	 System.out.println(u);
	            	 if(u.getNombre().equals(username)) {
	            		 correctou=true;
	            		 if(u.getContrasenia().equals(password)) {
		            		 correctocon=true;
		            		 correcto=u;
		            		 LoggerTodoCoches.logInicioSesion(u);
		            	 }
	            	 }
	            	 
	             }
	             if(correctocon && correctou) {
	            	 dispose();
		            AnimacionCarga.main(correcto);
	             }else if(correctou) {
	            	 JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
	            	 textPassword.setText("");
	             }else {
	            	 JOptionPane.showMessageDialog(null, "Usuario incorrecto");
	            	 textPassword.setText("");
	            	 textUsername.setText("");
	             }
	         }
	     });

	
	     buttonCancel.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             System.exit(0);
	         }
	     });
	     
	    
	        linkLabel.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	            	dispose();
	            	VentanaRegistro vr= new VentanaRegistro();
	            	vr.setVisible(true);
	            }
	        });
	     
	    
	     panel.add(labelUsername);
	     panel.add(labelPassword);
	     panel.add(textUsername);
	     panel.add(textPassword);
	     panel.add(linkLabel);
	     panel.add(buttonLogin);
	     panel.add(buttonCancel);


	     add(panel);


	     setVisible(true);
	     }

	     public static void main(String[] args) {
	         SwingUtilities.invokeLater(new Runnable() {
	             public void run() {
	                 new VentanaInicioSesion();
	             }
	         });
	     }
	     
}

