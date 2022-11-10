import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaMenu2 {

	private JFrame frame;
	private ImageIcon imagen;
	private ImageIcon icono;
	private JTextField textField;
	private JTextField txtPerfil;
	private JTable table;
	private static int fila=-1;
	private static int col=-1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu2 window = new VentanaMenu2();
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
	public VentanaMenu2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Connection con = BD.initBD("todoCoches.db");
		BD.crearTablas(con);
		BD.closeBD(con);
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		Coche c=new Coche("R8","Audi",2,0,2022,400,"src\\FOTOS\\audi r8.jpg");
		Usuario u=new Usuario("16097385F","2002/03/11","Asier","Teresa00","Getxo");
		Venta v=new Venta(c,u);
		class Renderer extends DefaultTableCellRenderer {
			/**
			 * 
			 */
			Venta v=new Venta(c,u);
			private static final long serialVersionUID = 1L;
			 //ImageIcon icon = new ImageIcon(getClass().getResource("sample.png"));

			 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			  boolean hasFocus, int row, int column) {
			v.setText("Esto es un anuncio");
			//lbl.setIcon(icon);
			return v;
			}
			}
		DefaultTableModel dtm=new DefaultTableModel();
		Venta[] lista= {v};
		dtm.addRow(lista);
		dtm.addColumn("");
		table.setModel(dtm);
		
			   
			table.getColumnModel().getColumn(0).setCellRenderer(new Renderer());
			
			table.getColumnModel().getColumn(0).setPreferredWidth(288);
			table.getColumnModel().getColumn(0).setMinWidth(36);
			table.getColumnModel().getColumn(0).setMaxWidth(303);
			table.setRowHeight(50);
			
			
				table.setBounds(221, 85, 295, 197);
				
				frame.getContentPane().add(table);

				
				table.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						fila= table.rowAtPoint(e.getPoint());
						col= table.columnAtPoint(e.getPoint());
						System.out.println(fila +","+ col);
					}
				});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("src\\FOTOS\\fondo.jpg"));
		lblNewLabel_1.setBounds(120, 59, 431, 243);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		lblNewLabel.setBounds(24, 0, 66, 69);
		
		imagen(lblNewLabel, "src\\FOTOS\\74472.png");
		

		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.setBounds(100, 20, 29, 29);
		imagenb(btnNewButton,"src\\FOTOS\\menu_icon-icons.com_69502.png");
		frame.getContentPane().add(btnNewButton);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnNewButton, popupMenu);
		
		txtPerfil = new JTextField();
		txtPerfil.setText("Perfil\r\n");
		popupMenu.add(txtPerfil);
		txtPerfil.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(439, 25, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Buscar:");
		lblNewLabel_2.setBounds(409, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setIcon(new ImageIcon("src\\FOTOS\\images.jpeg"));
		lblNewLabel_3.setBounds(0, 60, 129, 243);
		frame.getContentPane().add(lblNewLabel_3);
		JLabel foto= new JLabel("esto es una foto");

		
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
