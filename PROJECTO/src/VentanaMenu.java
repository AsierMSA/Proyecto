import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import rsscalelabel.RSScaleLabel;

import javax.swing.ImageIcon;
import java.awt.Button;

public class VentanaMenu {

	private JFrame frame;
	private ImageIcon imagen;
	private ImageIcon icono;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu window = new VentanaMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		lblNewLabel.setBounds(10, 10, 86, 86);
		imagen(lblNewLabel, "C:\\Users\\Estudiar\\OneDrive\\Documents\\74472.png");
		

		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.setBounds(100, 20, 29, 29);
		imagenb(btnNewButton,"C:\\Users\\Estudiar\\OneDrive\\Im\u00E1genes\\menu_icon-icons.com_69502.png");
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Estudiar\\OneDrive\\Im\u00E1genes\\fondo.jpg"));
		lblNewLabel_1.setBounds(130, 60, 431, 243);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(439, 25, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Buscar:");
		lblNewLabel_2.setBounds(409, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Estudiar\\OneDrive\\Im\u00E1genes\\images.jpeg"));
		lblNewLabel_3.setBounds(0, 60, 129, 243);
		frame.getContentPane().add(lblNewLabel_3);
		
	}
	
	private void imagen(JLabel l , String ruta) {
		this.imagen=new ImageIcon(ruta);
		this.icono= new ImageIcon(this.imagen.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
		l.setIcon(this.icono);
	}
	private void imagenb(JButton l , String ruta) {
		this.imagen=new ImageIcon(ruta);
		this.icono= new ImageIcon(this.imagen.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
		l.setIcon(this.icono);
	}
}