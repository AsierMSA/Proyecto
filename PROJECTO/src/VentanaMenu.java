import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class VentanaMenu {

	private JFrame frame;
	private ImageIcon imagen;
	private ImageIcon icono;
	private JTextField textField;
	private JTextField txtPerfil;
	private JTable table;
	private int fila=-1;
	private int col=-1;
	private VentanaVenta2 vc;
	private static Venta vactual;
	static Coche c=new Coche("R8","Audi",2,0,2022,400,"src\\FOTOS\\audi r8.jpg");
	static Usuario u=new Usuario("16097385F","2002/03/11","Asier","Teresa00","Getxo");
	static Coche cu=new Coche("R8","Audo",2,0,2022,400,"src\\FOTOS\\tesla.jpg");
	static Usuario uc=new Usuario("16097385F","2002/03/11","Ernesto","Teresa00","Getxo");
	static Coche ucc=new Coche("R8","Audo",2,0,2022,400,"src\\FOTOS\\Seat-arona-red-line-e1657284471337-1200x676.jpg");
	static Usuario ucv=new Usuario("16097385F","2002/03/11","Ernesto","Teresa00","Getxo");
	static Venta v=new Venta(c,u);
	static Venta vv=new Venta(cu,uc);
	static Venta vvv=new Venta(ucc,ucv);
	private static Venta[] lista= {v,vv,vvv};
	ArrayList<Venta> nuevalista;
	private static int i;
	private static int ch=-1;
	private static Usuario UsuarioActual;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu window = new VentanaMenu(null);
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
	public VentanaMenu(Usuario u) {
		UsuarioActual=u;
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
		table.setCellSelectionEnabled(true);
		table.setShowVerticalLines(false);

		class Renderer extends DefaultTableCellRenderer {
			/**
			 * 
			 */
			

			private static final long serialVersionUID = 1L;
			 //ImageIcon icon = new ImageIcon(getClass().getResource("sample.png"));

			 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			  boolean hasFocus, int row, int column) {
				i=row;
			if(col==column && fila==row) {
				if(ch!=-1) {
					vactual= nuevalista.get(i);
				}else {
				i=row;
				vactual=lista[i];
				}
				
//				System.out.println(vactual.getU());
			}
			if(ch!=-1) {
				return nuevalista.get(i);
			}
			

			return lista[i];
			
			}
			 
			}

		table.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				fila=table.rowAtPoint(e.getPoint());
				col=table.columnAtPoint(e.getPoint());
			
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
				vc= new VentanaVenta2(vactual);
				
				vc.setVisible(true);
				
			}
		});
		
		table.setDefaultEditor( Object.class, new TableCellEditor() {
			
			@Override
			public boolean isCellEditable(EventObject anEvent) {
				

				
				return false;
			}
			

			@Override
			public Object getCellEditorValue() {
				
				return null;
			}

			@Override
			public boolean shouldSelectCell(EventObject anEvent) {
				
				
				return false;
			}

			@Override
			public boolean stopCellEditing() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void cancelCellEditing() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void addCellEditorListener(CellEditorListener l) {
				
				
			}

			@Override
			public void removeCellEditorListener(CellEditorListener l) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
			
				
				
				return null;
			}
		});

		
		DefaultTableModel dtm=new DefaultTableModel();
		for(int i=0;i<lista.length;i++) {
			Venta[] v= {lista[i]};
			dtm.addRow(v);
		}
		
		dtm.addColumn("");

		table.setModel(dtm);
		
			   
			table.getColumnModel().getColumn(0).setCellRenderer(new Renderer());
			table.getColumnModel().getColumn(0).setPreferredWidth(288);
			table.getColumnModel().getColumn(0).setMinWidth(36);
			table.getColumnModel().getColumn(0).setMaxWidth(303);
			
			
			table.setRowHeight(50);
			
			
				table.setBounds(221, 85, 295, 197);
				
				frame.getContentPane().add(table);

				
			
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("src\\FOTOS\\fondo.jpg"));
		lblNewLabel_1.setBounds(120, 59, 431, 243);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("VENDER\r\n");
		btnNewButton_1.setBounds(10, 259, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
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
		textField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					DefaultTableModel dfnew=new DefaultTableModel();
					dfnew.addColumn("");
//					System.out.println(textField.getText());
					
					String buscar=new String(textField.getText());
					textField.setText("");
					nuevalista = new ArrayList<Venta>();
					
					for(int i=0;i<lista.length;i++) {
						
						if(lista[i].getU().getNombre().equals(buscar)) {
							System.out.println(lista[i].getU().getNombre());
							Venta[] enc= {lista[i]};
							nuevalista.add(lista[i]);
							dfnew.addRow(enc);
							table.setModel(dfnew);
							ch=i;
							
						}
					}
					table.getColumnModel().getColumn(0).setCellRenderer(new Renderer());
					table.getColumnModel().getColumn(0).setPreferredWidth(288);
					table.getColumnModel().getColumn(0).setMinWidth(36);
					table.getColumnModel().getColumn(0).setMaxWidth(303);
					table.repaint();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Buscar:");
		lblNewLabel_2.setBounds(409, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setIcon(new ImageIcon("src\\FOTOS\\images.jpeg"));
		lblNewLabel_3.setBounds(0, 60, 129, 243);
		frame.getContentPane().add(lblNewLabel_3);
		JLabel foto= new JLabel("esto es una foto");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaVenta vco=new VentanaVenta();
				vco.setVisible(true);
				
			}
		});
		
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
