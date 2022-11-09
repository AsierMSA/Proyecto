import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDatos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDatos frame = new VentanaDatos();
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
	public VentanaDatos() {
		setTitle("DATOS PERSONALES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnl_centro = new JPanel();
		contentPane.add(pnl_centro, BorderLayout.CENTER);
		pnl_centro.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lbl_nombre = new JLabel("NOMBRE:");
		pnl_centro.add(lbl_nombre);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		pnl_centro.add(lblNewLabel_1);
		
		JLabel lbl_dni = new JLabel("DNI:");
		pnl_centro.add(lbl_dni);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		pnl_centro.add(lblNewLabel_3);
		
		JLabel lbl_ciudad = new JLabel("CIUDAD:");
		pnl_centro.add(lbl_ciudad);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		pnl_centro.add(lblNewLabel_5);
		
		JLabel lbl_fechaNacimiento = new JLabel("FECHA DE NACIMIENTO:");
		pnl_centro.add(lbl_fechaNacimiento);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		pnl_centro.add(lblNewLabel_7);
		
		JLabel lbl_contrasenia = new JLabel("CONTRASENIA:");
		pnl_centro.add(lbl_contrasenia);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		pnl_centro.add(lblNewLabel_9);
		
		JPanel pnl_oeste = new JPanel();
		contentPane.add(pnl_oeste, BorderLayout.WEST);
		
		JPanel pnl_sur = new JPanel();
		contentPane.add(pnl_sur, BorderLayout.SOUTH);
		
		JButton btn_salir = new JButton("SALIR");
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pnl_sur.add(btn_salir);
		
		JPanel pnl_este = new JPanel();
		contentPane.add(pnl_este, BorderLayout.EAST);
		
		JPanel pnl_norte = new JPanel();
		contentPane.add(pnl_norte, BorderLayout.NORTH);
		
		JLabel lbl_datos_personales = new JLabel("DATOS PERSONALES");
		pnl_norte.add(lbl_datos_personales);
	}

}
