import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

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
	private static Venta vactual;
	private static VentanaVenta2 vc;
	static int fila=-1;
	static int col=-1;
	static int i=-1;
	private static Usuario uactual;
	private static Venta[] listad;
	private static JScrollPane js=null;
	private static int ch=-1;
	private static Venta[] nuevalista;

	public static Venta[] getNuevalista() {
		return nuevalista;
	}

	public static void setNuevalista(Venta[] nuevalista) {
		VentanaPerfil.nuevalista = nuevalista;
	}

	public int getCh() {
		return ch;
	}

	public static void setCh(int ch) {
		VentanaPerfil.ch = ch;
	}
	private static JTable table1;
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
		VentanaPerfil.uactual=u;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1250, 100, 500, 550);
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
        
        lblNewLabel_3 = new JLabel("    ");
        panel_5.add(lblNewLabel_3);
        JPanel panel_2 = new JPanel();
        
 
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
        JTable table=new JTable();
        Venta[] compras=new Venta[10];
        int i=0;
        for(String s: BD.getMapaCompras().keySet()) {
        	if(s.equals(u.getDni())) {
        		ArrayList<Coche> comprasc=BD.getMapaCompras().get(s);
        		for(Coche c: comprasc) {
        			Venta v=new Venta(c, u, "");
        			compras[i]=v;
        			i++;
        		}
        	}
        }
       
		        panel_1.add(crearTabla(table, compras,true),BorderLayout.CENTER);
		        tabbedPane.addTab("COMPRAS", null, panel_1, null);
		        
		        table1=new JTable();
		        Venta[] ventas=new Venta[10];
		        i=0;
		        for(String s: BD.getMapaVentas().keySet()) {
		        	if(s.equals(u.getDni())) {
		        		ArrayList<Coche> ventasc=BD.getMapaVentas().get(s);
		        		for(Coche c: ventasc) {
		        			Venta v=new Venta(c, u, "");
		        			ventas[i]=v;
		        			i++;
		        		}
		        	}
		        }
		        panel_2.add(crearTabla(table1,ventas,true),BorderLayout.CENTER);
		        tabbedPane.addTab("VENTAS", null, panel_2, null);
			
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


		 public static JTable getTable1() {
		return table1;
	}

	public void setTable1(JTable table1) {
		VentanaPerfil.table1 = table1;
	}

		public static JScrollPane crearTabla(JTable table,Venta[] lista,boolean editar) {

			 table.addMouseMotionListener(new MouseMotionListener() {
					
					@Override
					public void mouseMoved(MouseEvent e) {
						fila = table.rowAtPoint(e.getPoint());
						col=table.columnAtPoint(e.getPoint());

					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});


			 
			 DefaultTableModel dtm=new DefaultTableModel();
				dtm.addColumn("");
				for(int j=0;j<lista.length;j++) {
					
					if(lista[j]!=null) {
					
					if(lista[j].getU().getDni().equals(uactual.getDni())){
					Venta[] v= {lista[j]};
					dtm.addRow(v);
					}
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
			
								i=row;
								vactual=lista[i];
							}
						return lista[i];
					}	 
					}
		
					

					table.setModel(dtm);
				
					   
					table.getColumnModel().getColumn(0).setCellRenderer(new Renderer());
					table.getColumnModel().getColumn(0).setPreferredWidth((int) (450*0.65));
					table.getColumnModel().getColumn(0).setMaxWidth((int) (450.65));
					
					
					
					table.setRowHeight((int) (400*0.20));
					if(editar) {
						table.addMouseListener(new MouseAdapter() {
							
							@Override
							public void mouseClicked(MouseEvent e) {
						
								try {
									vc=new VentanaVenta2(vactual);
								} catch (MalformedURLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}	
								vc.setVisible(true);
									

								
							}
						});
					js=new JScrollPane(table);
					  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					  js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					  js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					  table.setFillsViewportHeight(false);
					}
					  return js;
		
		
	}
		 
		 

}
