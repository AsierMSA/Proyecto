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
import EXCEPCIONES.FechaException;
import EXCEPCIONES.Fecha;
import EXCEPCIONES.PasswordException;
public class VentanaRegistro extends JFrame {

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
	private JButton btnRegistro;
	private JButton btnSalir;
	private JPanel panelIzda;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblNombre;
	private JTextField txtCiudad;
	private JLabel lblContrasenia;
	private JPasswordField txtContrasenia;
	private JLabel lblRegistro;
	private JLabel lblCiudad;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JTextField textField_1;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		
		
		setTitle("REGISTRO");
		
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

		btnSalir = new JButton("CERRAR SESION");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0); //Cierra la aplicaci√≥n
			}
		});

		btnSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panelSur.add(btnSalir);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblRegistro = new JLabel("REGISTRO");
		panelNorte.add(lblRegistro);
		
		panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(1, 2, 0, 0));
		
		panelIzda = new JPanel();
		panelCentro.add(panelIzda);
		panelIzda.setLayout(new GridLayout(6, 2, 0, 0));
		
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
		
		lblContrasenia = new JLabel("CONTRASE—A");
		
		panelIzda.add(lblContrasenia);
		
				
				txtContrasenia = new JPasswordField();
				panelIzda.add(txtContrasenia);
				txtContrasenia.setColumns(10);
		

		lblContrasenia = new JLabel("CONTRASENIA");
		
		lblFecha=new JLabel("FECHA");
		panelIzda.add(lblFecha);
		
		txtFecha = new JTextField();
		panelIzda.add(txtFecha);
		
		lblCiudad = new JLabel("CIUDAD");
		panelIzda.add(lblCiudad);
		
		
		
		
		txtCiudad = new JTextField();
		panelIzda.add(txtCiudad);
		txtCiudad.setColumns(10);
		


		lblCiudad = new JLabel("FOTO(opcional)\r\n");
		panelIzda.add(lblCiudad);
		
		btnNewButton = new JButton("SELECCIONAR\r\n\r\n");
		panelIzda.add(btnNewButton);
		


		new JLabel("Introduce tu contrasenia:");
		
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
			       btnNewButton.setText(chooser.getSelectedFile().getAbsolutePath());
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
				if(!textField_1.getText().equals("") && !txtDni.getText().equals("") && !txtCiudad.getText().equals("")
						&& comprobarFecha(txtFecha.getText())!=null ) {
			        try {
			            comprobarPassword(c);
			            System.out.println("La contraseÒa es v·lida.");
			            new Usuario(txtDni.getText(), c, textField_1.getText(), c,txtCiudad.getText(), btnNewButton.getText(), 0, false);
			        } catch (PasswordException ea) {
			            System.out.println(ea.getMessage());
			        }
				}else {
					JOptionPane.showMessageDialog(rootPane, "Rellena todos los campos obligatorios");
				}
				
			}
		});

	}
	public String comprobarFecha(String fecha) {
        try {
            new Fecha(fecha);
        } catch (FechaException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return fecha; 
	}
	
    public String comprobarPassword(String password) throws PasswordException {
        if(password.length() < 8) {
        	password=null;
            throw new PasswordException("La contraseÒa debe tener al menos 8 caracteres.");
        }
        if(!password.matches(".*\\d.*")) {
        	password=null;
            throw new PasswordException("La contraseÒa debe tener al menos un n˙mero.");
        }
        return password;

    }

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

}
