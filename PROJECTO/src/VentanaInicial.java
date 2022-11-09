import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaInicial extends JFrame {

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
	private JTextField txtNombre;
	private JLabel lblFechaNac;
	private JTextField txtFechaNacimiento;
	private JLabel lblContrasenia;
	private JPasswordField txtContrasenia;
	private JLabel lblRegistro;
	private JLabel lblInicioSesion;
	private JLabel lblDNIInicioSesion;
	private JTextField txtDNIInicioSesion;
	private JLabel lblContraseniaInicioSesion;
	private JPasswordField txtContraseniaInicioSesion;
	private JLabel lblNumero;
	private JTextField txtNumero;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicial() {
		
		
		setTitle("INICIO SESIÓN");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnInicioSesion = new JButton("INICIO SESION");
	
		btnInicioSesion.setBackground(Color.CYAN);
		btnInicioSesion.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panelSur.add(btnInicioSesion);
		
		btnRegistro = new JButton("REGISTRO");
		
		btnRegistro.setBackground(Color.GREEN);
		btnRegistro.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panelSur.add(btnRegistro);
		
		btnSalir = new JButton("CERRAR SESION");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0); //Cierra la aplicación
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
		
		txtNombre = new JTextField();
		panelIzda.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblFechaNac = new JLabel("FECHA NACIMIENTO");
		panelIzda.add(lblFechaNac);
		
		txtFechaNacimiento = new JTextField();
		panelIzda.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		lblContrasenia = new JLabel("CONTRASENIA");
		panelIzda.add(lblContrasenia);
		
		txtContrasenia = new JPasswordField();
		panelIzda.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		lblNumero = new JLabel("Introduce un numero:;");
		panelIzda.add(lblNumero);
		
		txtNumero = new JTextField();
		panelIzda.add(txtNumero);
		txtNumero.setColumns(10);
		
		panelDcha = new JPanel();
		panelCentro.add(panelDcha);
		panelDcha.setLayout(new GridLayout(2, 2, 0, 0));
		
		lblDNIInicioSesion = new JLabel("Introduce tu dni: ");
		panelDcha.add(lblDNIInicioSesion);
		
		txtDNIInicioSesion = new JTextField();
		panelDcha.add(txtDNIInicioSesion);
		txtDNIInicioSesion.setColumns(10);
		
		lblContraseniaInicioSesion = new JLabel("Introduce tu contrasenia:");
		panelDcha.add(lblContraseniaInicioSesion);
		
		txtContraseniaInicioSesion = new JPasswordField();
		panelDcha.add(txtContraseniaInicioSesion);
		txtContraseniaInicioSesion.setColumns(10);
	}

}