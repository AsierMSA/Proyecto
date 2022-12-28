import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class VentanaPerfil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPerfil frame = new VentanaPerfil(new Usuario("", "", "", "", "", "", true));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public VentanaPerfil(Usuario  u) throws IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		
		JLabel Perfil = new JLabel();
		Perfil.setText(u.getNombre());
		Image img1 = ImageIO.read(new File("src\\\\FOTOS\\\\74472.png"));
		Image dimg1 = img1.getScaledInstance(85, 75,
		        Image.SCALE_SMOOTH);
		ImageIcon logo1=new ImageIcon(dimg1);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		Perfil.setIcon(logo1);
		panelSuperior.add(Perfil, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JPanel editar=new JPanel();
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("COMPRAS", null, panel_1, null);
        editar.setLayout(new BorderLayout(0, 0));
        JPanel panel_5=new JPanel();
        
        JButton CambiarFoto = new JButton("Editar Foto");
        panel_5.add(CambiarFoto);
        CambiarFoto.setHorizontalAlignment(SwingConstants.RIGHT);
        CambiarFoto.addActionListener(new ActionListener() {
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
			       lblNewLabel_3.setText(chooser.getSelectedFile().getName());
			    }
        	}
        });
        editar.add(panel_5,BorderLayout.WEST);
        
        lblNewLabel_3 = new JLabel("New label");
        panel_5.add(lblNewLabel_3);
        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("VENTAS", null, panel_2, null);
 
        tabbedPane.addTab("EDITAR", editar);
        
        JButton btnNewButton = new JButton("ACEPTAR CAMBIOS");
        JPanel panel_4=new JPanel();
        panel_4.add(btnNewButton);
        editar.add(panel_4,BorderLayout.SOUTH);
        btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() && textField_1.getText().isEmpty() && textField_2.getText().isEmpty() && textField_3.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(rootPane, "Rellena todos los campos obligatorios");
				}else {
					
				}
				
			}
		});
        
        JPanel panel_3 = new JPanel();
        editar.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 2, 0, 0));
        
        JLabel lblNewLabel = new JLabel("NOMBRE");
        panel_3.add(lblNewLabel);
        
        textField = new JTextField(u.getNombre());
        panel_3.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
        panel_3.add(lblNewLabel_1);
        
        textField_1 = new JTextField(u.getContrasenia());
        panel_3.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("CIUDAD");
        panel_3.add(lblNewLabel_2);
        
        textField_2 = new JTextField(u.getCiudad());
        panel_3.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("DNI");
        panel_3.add(lblNewLabel_4);
        
        textField_3 = new JTextField(u.getDni());
        panel_3.add(textField_3);
        textField_3.setColumns(10);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

}
