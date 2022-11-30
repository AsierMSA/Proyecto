import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.EventObject;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

public class INTENTOMENU {

	private JFrame frame;
	private JPanel panel;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelCentral;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private int fila=-1;
	private int col=-1;
	static int pos;
	private static int i;
	private static int ch=-1;
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
	private static Venta[] lista= {v,vv,vvv,vvv};
	Venta[] nuevalista;
	private JTable table;
	private JButton Volver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INTENTOMENU window = new INTENTOMENU();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public INTENTOMENU() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 627, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		PanelSuperior = new JPanel();
		PanelSuperior.setBackground(Color.WHITE);
		panel.add(PanelSuperior, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel();
		Image img = ImageIO.read(new File("src\\\\FOTOS\\\\106829_05062017.jpg"));
		Image dimg = img.getScaledInstance(130, 65,
		        Image.SCALE_SMOOTH);
		ImageIcon logo=new ImageIcon(dimg);
		lblNewLabel.setIcon(logo);
		PanelSuperior.add(lblNewLabel);
		
		panel_1 = new JPanel();
		PanelSuperior.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("      Buscar:");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		PanelInferior = new JPanel();
		panel.add(PanelInferior, BorderLayout.SOUTH);
		
		btnNewButton_2 = new JButton("New button");
		PanelInferior.add(btnNewButton_2);
		
		Volver = new JButton("");
		Volver.setIcon(new ImageIcon(INTENTOMENU.class.getResource("/FOTOS/back.png")));
		Volver.setVisible(false);
		PanelInferior.add(Volver);
		
		PanelCentral = new JPanel();
		panel.add(PanelCentral, BorderLayout.CENTER);
		PanelCentral.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		PanelCentral.add(panel_2);
		
		lblNewLabel_2 = new JLabel("New label");
		panel_2.add(lblNewLabel_2);
		
		panel_3 = new JPanel();
		PanelCentral.add(panel_3, BorderLayout.EAST);
		
		table = new JTable();
		panel_3.add(table);
		table.setCellSelectionEnabled(true);
		table.setShowVerticalLines(false);

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
		Volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ch=-1;
				cambModel(lista);
				Volver.setVisible(false);
				lblNewLabel_1.setText("      Buscar:");
				
			}
		} );
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
				
				String buscar=new String(textField.getText());
				textField.setText("");
				nuevalista = new Venta[50];
				pos=0;
				
				for(int i=0;i<lista.length;i++) {
					
					if(lista[i].getU().getNombre().equals(buscar)) {
						System.out.println(lista[i].getU().getNombre());
						nuevalista[pos]=lista[i];
						pos++;
						ch=i;
						
						
					}
				}
			Volver.setVisible(true);
			cambModel(nuevalista);
			lblNewLabel_1.setText(pos+" articulos encontrados");
			}
			
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
		cambModel(lista);
	}
		private void cambModel(Venta[] listad) {
			// TODO Auto-generated method stub
			DefaultTableModel dtm=new DefaultTableModel();
			for(int i=0;i<listad.length;i++) {
				if(listad[i]!=null) {
				Venta[] v= {listad[i]};
				dtm.addRow(v);
				System.out.println(i);
				}
			}

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
						vactual= nuevalista[i];
					}else {
					i=row;
					vactual=lista[i];
					}
					
//					System.out.println(vactual.getU());
				}
				if(ch!=-1) {
					return nuevalista[i];
				}
				return lista[i];
				}	 
				}
			
				dtm.addColumn("");

				table.setModel(dtm);
			
				   
				table.getColumnModel().getColumn(0).setCellRenderer(new Renderer());
				table.getColumnModel().getColumn(0).setPreferredWidth((int) (frame.getWidth()*0.65));
				table.getColumnModel().getColumn(0).setMaxWidth((int) (frame.getWidth()*0.65));
				panel_3.setLayout(new BorderLayout(0, 0));
				
				
				table.setRowHeight((int) (frame.getHeight()*0.20));
		
			JScrollPane js=new JScrollPane(table);
			  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel_3.add(js);
		
	


	}

}
