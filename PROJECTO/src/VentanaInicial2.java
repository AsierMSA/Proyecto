import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaInicial2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelSur;
	private JPanel panelNorte;
	private JPanel panelOeste;
	private JPanel panelEste;
	private JPanel panelCentro;
	private JButton btnInicioSesion;
	private JButton btnRegistro;
	private JButton btnSalir;
	private JPanel panelIzda;
	private JPanel panelDcha;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblNombre;
	private JTextField txtCiudad;
	private JLabel lblContrasenia;
	private JPasswordField txtContrasenia;
	private JLabel lblRegistro;
	private JLabel lblInicioSesion;
	private JLabel lblDNIInicioSesion;
	private JTextField txtDNIInicioSesion;
	private JLabel lblContraseniaInicioSesion;
	private JPasswordField txtContraseniaInicioSesion;
	private JTextField txtNumero;
	private JLabel lblCiudad;
	private JTextField textField_1;
	private static ArrayList<Usuario> lu;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial2 frame = new VentanaInicial2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crear el frame
	 */
	public VentanaInicial2() {
		
		
		setTitle("INICIO SESION");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnRegistro = new JButton("REGISTRO");
		
		btnRegistro.setBackground(Color.GREEN);
		btnRegistro.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panelSur.add(btnRegistro);
		
		btnInicioSesion = new JButton("INICIO SESION");
	
		btnInicioSesion.setBackground(Color.CYAN);
		btnInicioSesion.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panelSur.add(btnInicioSesion);
		
		btnSalir = new JButton("CERRAR SESION");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0); //Cierra la aplicaciÃ³n
			}
		});

		btnSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panelSur.add(btnSalir);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblRegistro = new JLabel("REGISTRO");
		panelNorte.add(lblRegistro);
		
		lblInicioSesion = new JLabel("INICIO SESION");
		panelNorte.add(lblInicioSesion);
		
		panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(1, 2, 0, 0));
		
		panelIzda = new JPanel();
		panelCentro.add(panelIzda);
		panelIzda.setLayout(new GridLayout(5, 2, 0, 0));
		
		lblDni = new JLabel("DNI");
		panelIzda.add(lblDni);
		
		txtDni = new JTextField();
		panelIzda.add(txtDni);
		txtDni.setColumns(10);
		
		lblNombre = new JLabel("NOMBRE");
		panelIzda.add(lblNombre);
		
		textField_1 = new JTextField();
		panelIzda.add(textField_1);
		textField_1.setColumns(10);
		
		lblContrasenia = new JLabel("CONTRASEÑA");
		
		panelIzda.add(lblContrasenia);
		
				
				txtContrasenia = new JPasswordField();
				panelIzda.add(txtContrasenia);
				txtContrasenia.setColumns(10);
		

		lblContrasenia = new JLabel("CONTRASENIA");
		
		lblCiudad = new JLabel("CIUDAD");
		panelIzda.add(lblCiudad);
		
		txtCiudad = new JTextField();
		panelIzda.add(txtCiudad);
		txtCiudad.setColumns(10);
		


		lblCiudad = new JLabel("FOTO(opcional)\r\n");
		panelIzda.add(lblCiudad);
		
		btnNewButton = new JButton("SELECCIONAR\r\n\r\n");
		panelIzda.add(btnNewButton);

		//lblNumero = new JLabel("Introduce un número:;");
		//panelIzda.add(lblNumero);

		
		//textField = new JTextField();
		//panelIzda.add(textField);
		//textField.setColumns(10);

		panelDcha = new JPanel();
		panelCentro.add(panelDcha);
		panelDcha.setLayout(new GridLayout(2, 2, 0, 0));
		
		lblDNIInicioSesion = new JLabel("DNI\r\n");
		panelDcha.add(lblDNIInicioSesion);
		
		txtDNIInicioSesion = new JTextField();
		panelDcha.add(txtDNIInicioSesion);
		txtDNIInicioSesion.setColumns(10);
		


		lblContraseniaInicioSesion = new JLabel("Introduce tu contrasenia:");

		lblContraseniaInicioSesion = new JLabel("CONTRASE\u00D1A\r\n");

		panelDcha.add(lblContraseniaInicioSesion);

		
		txtContraseniaInicioSesion = new JPasswordField();
		panelDcha.add(txtContraseniaInicioSesion);
		txtContraseniaInicioSesion.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf= new JFileChooser();
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & GIF Images", "jpg", "gif");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(jf);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			       btnNewButton.setText(chooser.getSelectedFile().getName());
			    }
			    
				
			}
		});
		btnRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String c="";
				for(int j=0;j<txtContrasenia.getPassword().length;j++) {
					c=c.concat(String.valueOf(txtContrasenia.getPassword()[j]));
				}
				if(!textField_1.getText().equals("") && !txtDni.getText().equals("") && !c.equals("") && !txtCiudad.getText().equals("")) {
					System.out.println("hecho");
					
				}else {
					JOptionPane.showMessageDialog(rootPane, "Rellena todos los campos obligatorios");
				}
				
			}
		});
		btnInicioSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			if(txtContraseniaInicioSesion.getPassword().length!=0 && !txtDNIInicioSesion.getText().equals("") ) {
				String c="";
				for(int j=0;j<txtContraseniaInicioSesion.getPassword().length;j++) {
					c=c.concat(String.valueOf(txtContraseniaInicioSesion.getPassword()[j]));
				}
				System.out.println(c);
				for(int i=0;i<lu.size();i++) {
					if(c.equals(lu.get(i).getContrasenia()) && txtDNIInicioSesion.getText().equals(lu.get(i).getDni())) {
						dispose();
						try {
							INTENTOMENU v=new INTENTOMENU();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
				
					
				
				}else {
					JOptionPane.showMessageDialog(rootPane, "Rellena todos los campos");
					
				}
				
			}
		});
	}

}
