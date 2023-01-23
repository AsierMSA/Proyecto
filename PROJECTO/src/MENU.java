import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;



import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MENU {
	final Logger LOG = Logger.getLogger("paquete.NombreClase");
	static JFrame frame;
	public static JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		
		MENU.frame = frame;
	}
	private static JPanel panel;
	private JPanel PanelSuperior;
	private JPanel PanelInferior;
	private JPanel PanelCentral;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private static JPanel panel_2;
	private static JPanel panel_3;
	private static int fila=-1;
	private static int col=-1;
	static int pos;
	private static int i;
	private static int ch=-1;
	private VentanaVenta2 vc;
	
	//Usuario por defecto

	static Usuario u=new Usuario("16097385F","2002/03/11","Asier","Teresa00","Getxo","",100000, true);

	private static Venta[] lista;
	
	public static Venta[] getLista() {
		return lista;
	}

	public static void setLista(Venta[] lista) {
		MENU.cambModel(lista, table);
		MENU.lista=lista;
	}
	static Venta[] nuevalista;
	private static Venta vactual;
	private static Usuario uactual;
	
	public static Usuario getUactual() {
		return uactual;
	}

	public static void setUactual(Usuario uactual) {
		MENU.uactual = uactual;
	}
	private static JTable table;
	public static JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		MENU.table = table;
	}
	private JButton Volver;
	private static JScrollPane js=null;
	private JMenuBar barraMenu;
	private JComboBox<String> comboBoxFiltrar;
	private JComboBox<String> comboBoxFiltrar_1;
	private static JSplitPane PanelC;
	private JLabel lblNewLabel_2;
	private JSlider precioSlider;
	private JLabel precioRango_1;
	private JPanel panel_4;
	static JLabel Perfil;
	static Boolean reset=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MENU m=new MENU(u);
					m.frame.setVisible(true);
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

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	MENU(Usuario us) throws IOException {
		us=MENU.uactual;
		cargarListaBD();
		frame = new JFrame();
		ImageIcon icono= new ImageIcon("src//FOTOS//window.png");
		frame.setIconImage(icono.getImage());
		LOG.log(Level.INFO, MENU.uactual.getNombre()+" sesion iniciada");
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		
		frame.setSize(anchoP, altoP);
		//frame.MAXIMIZED_BOTH;
		//frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		PanelSuperior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) PanelSuperior.getLayout();
		flowLayout.setHgap(10);
		PanelSuperior.setBackground(Color.WHITE);
		panel.add(PanelSuperior, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel();
		Image img = ImageIO.read(new File("src\\FOTOS\\106829_05062017.jpg"));
		Image dimg = img.getScaledInstance(130, 65,
		        Image.SCALE_SMOOTH);
		ImageIcon logo=new ImageIcon(dimg);
		lblNewLabel.setIcon(logo);
		PanelSuperior.add(lblNewLabel);
		
		panel_1 = new JPanel();
		PanelSuperior.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNewButton = new JButton("Recomendaciones");
		panel_1.add(btnNewButton);
		
		btnNewButton_3 = new JButton("Estadisticas");
		panel_1.add(btnNewButton_3);
		if(!uactual.getAdmin()) {
			btnNewButton_3.setVisible(false);
		}
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			VentanaEstadistica ve= new VentanaEstadistica();
			ve.setVisible(true);
				
			}
		});
		
		String [] marca= {"MARCA","BMW","AUDI","TESLA","MERCEDES"};
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(marca);
		
		
		String[] km= {"MaxKm","10000","20000","30000","100000"};
		DefaultComboBoxModel<String> comboModel2 = new DefaultComboBoxModel<String>(km);
		PanelInferior = new JPanel();
		panel.add(PanelInferior, BorderLayout.SOUTH);
		
		lblNewLabel_1 = new JLabel("Buscar:  ");
		lblNewLabel_1.setSize(20, lblNewLabel_1.getHeight());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		Perfil = new JLabel();
		Perfil.setHorizontalAlignment(SwingConstants.RIGHT);
		Image img1 = ImageIO.read(new File("src\\\\FOTOS\\\\74472.png"));
		Image dimg1 = img1.getScaledInstance(65, 45,
		        Image.SCALE_SMOOTH);
		ImageIcon logo1=new ImageIcon(dimg1);
		Perfil.setIcon(logo1);
		Perfil.setText(MENU.uactual.getCartera()+"€          "+MENU.uactual.getNombre());
		PanelSuperior.add(Perfil);
		
		lblNewLabel_2 = new JLabel("");
		PanelInferior.add(lblNewLabel_2);
		btnNewButton_2 = new JButton("Vender");
		PanelInferior.add(btnNewButton_2);
		

		
		Volver = new JButton("");
		Volver.setIcon(new ImageIcon(MENU.class.getResource("/FOTOS/back.png")));
		Volver.setVisible(false);
		PanelInferior.add(Volver);
		
		PanelCentral = new JPanel();
		panel.add(PanelCentral, BorderLayout.CENTER);
		PanelCentral.setLayout(new BorderLayout(3, 1));
		
		panel_2 = new JPanel();
		PanelCentral.add(panel_2, BorderLayout.CENTER);
						
		new JLabel("Añadir fondos");
		panel_2.setLayout(new GridLayout(0, 1, 0, 50));
		
		panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(7, 1, 0, 0));
										
												
		comboBoxFiltrar = new JComboBox<String>(comboModel);
		panel_4.add(comboBoxFiltrar);
										
												
												
		comboBoxFiltrar_1 = new JComboBox<String>(comboModel2);
		panel_4.add(comboBoxFiltrar_1);
									
		precioSlider = new JSlider(0,100000);
		panel_4.add(precioSlider);
		precioSlider.setPaintTicks(true);
		precioSlider.setSnapToTicks(true);
		precioSlider.setMinorTickSpacing(1000);
		precioSlider.setMajorTickSpacing(1000);
		precioSlider.setToolTipText("Precio");
										
												

										

		precioSlider.addChangeListener(new ChangeListener() {
											
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			final int value = source.getValue();
			SwingUtilities.invokeLater(new Runnable() {
			    @Override
			    public void run() {
			    	precioRango_1.setText(Integer.toString(value));
			    }
			});					
						}
				});
						
		
		
		precioRango_1 = new JLabel("50000");
		precioRango_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(precioRango_1);
						
		JButton filtrar = new JButton("Filtrar");
		filtrar.setVerticalTextPosition(SwingConstants.CENTER);
		panel_4.add(filtrar);
		JPanel Anuncio=new JPanel();
		JLabel anuncios=new JLabel();
		Thread hilo=new Thread() {
			@Override
			public void run() {
				
				String[] fotos= {"src\\FOTOS\\anuncio1.png","src\\FOTOS\\anuncio12.png"};
				int indiceImagen = 0;
				while(true) {
				
				try {
					BufferedImage img2 = ImageIO.read(new File(fotos[indiceImagen]));
					indiceImagen = (indiceImagen + 1) % fotos.length;
					Image dimg2 = img2.getScaledInstance(200, 160,
					        Image.SCALE_SMOOTH);
					ImageIcon logo2=new ImageIcon(dimg2);
					anuncios.setIcon(logo2);
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		};
		hilo.start();

		anuncios.setVerticalAlignment(JLabel.BOTTOM);
		Anuncio.add(anuncios);
		panel_2.add(Anuncio);
		filtrar.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_3=new JPanel();
		panel_3.setLayout(new BorderLayout(0, 0));
		PanelCentral.add(panel_3, BorderLayout.EAST);
		
		
		barraMenu = new JMenuBar();
		barraMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		JMenu mFicheros = new JMenu("Ficheros");
		JMenu mSalir = new JMenu("Salir");
		barraMenu.add(mFicheros);
		barraMenu.add(mSalir);
		JMenuItem mFicherosCargarFichero = new JMenuItem("Borrar compras");
		mFicherosCargarFichero.setMnemonic(KeyEvent.VK_C);
		JMenuItem mFicherosGuardarFicheros = new JMenuItem("Guardar");
		JMenuItem mSalirCerrarSesion = new JMenuItem("Cerrar Sesion ");
		mFicheros.add(mFicherosCargarFichero);
		mFicheros.add(mFicherosGuardarFicheros);
		mSalir.add(mSalirCerrarSesion);
		mFicherosCargarFichero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BD.resetCompras();
			}
		});
		mFicherosGuardarFicheros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BD.ActualizarVistas(BD.initBD("todoCoches.db", false));
			}
		});
		mSalirCerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MENU.getFrame().dispose();
				VentanaInicioSesion vi= new VentanaInicioSesion();
				vi.setVisible(true);
			}
		});
		filtrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!comboModel.getSelectedItem().equals("MARCA") && !comboModel2.getSelectedItem().equals("MaxKm")) {
					System.out.println(precioRango_1.getText());
					buscarLista(comboModel.getSelectedItem(), Integer.parseInt((String) comboModel2.getSelectedItem()),Integer.parseInt(precioRango_1.getText().split(";")[0]));
				
				}else {
					JOptionPane.showMessageDialog(null, "Selecciona un filtro");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reset=false;
				cambModel(recomendacionRecursiva(BD.mapaCompras.get(uactual.getDni()),getLista(),new Venta[5],0,0,0, new HashSet<Coche>()),table);
				Volver.setVisible(true);
				btnNewButton_2.setVisible(false);
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaVenta v=new VentanaVenta();
				v.setVisible(true);
				
			}
		});
		table = new JTable();
		table.setShowVerticalLines(false);
		panel_3.add(table);
		table.setCellSelectionEnabled(true);
		frame.setJMenuBar(barraMenu);
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
		table.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					vc= new VentanaVenta2(vactual);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				vc.setVisible(true);
				
			}
		});
		Volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reset=true;
				ch=-1;
				cambModel(lista, table);
				Volver.setVisible(false);
				lblNewLabel_2.setText("");
				btnNewButton_2.setVisible(true);
				
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
	Perfil.addMouseListener(new MouseAdapter() {
	
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				VentanaPerfil vp=new VentanaPerfil(uactual);
				vp.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
				String buscar=new String(textField.getText());
				textField.setText("");
				buscarLista(buscar,0, 0);
			}
			
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	cambModel(lista, table);
	}
		//Metodo para buscar un elemento de la lista y cambiar la tabla
	
		private void buscarLista(Object igual,int numero,int precio) {
			nuevalista = new Venta[50];
			pos=0;
			for(int i=0;i<lista.length;i++) {
				if(lista[i]!=null) {
				if(numero==0 && precio==0) {
					if(lista[i].getU().getNombre().toLowerCase().equals(igual.toString().toLowerCase()) || lista[i].getC().getMarca().toLowerCase().equals(igual.toString().toLowerCase()) || lista[i].getC().getModelo().toLowerCase().equals(igual.toString().toLowerCase()) 
					 ) {
					nuevalista[pos]=lista[i];
					pos++;
					ch=i;
					
				}
				}else if(precio==0){
					if(lista[i].getC().getMarca().toLowerCase().equals(igual.toString().toLowerCase()) && lista[i].getC().getKilometros()==numero) {
						nuevalista[pos]=lista[i];
						pos++;
						ch=i;
					}
					
				}else {
					if(lista[i].getC().getMarca().toLowerCase().equals(igual.toString().toLowerCase()) && lista[i].getC().getKilometros()<numero
							&& lista[i].getDinero()==precio){
						nuevalista[pos]=lista[i];
						pos++;
						ch=i;
					}
					
				}
				}
				}
			btnNewButton_2.setVisible(false);
			Volver.setVisible(true);
			cambModel(nuevalista, table);
			lblNewLabel_2.setText(pos+" articulos encontrados");
		}
		
		//Metodo para cambiar el DefaultTableModel de la tabla
		 
		static void cambModel(Venta[] listad,JTable table) {
			// TODO Auto-generated method stub
			DefaultTableModel dtm=new DefaultTableModel();
			dtm.addColumn("");
			for(int i=0;i<listad.length;i++) {
				if(listad[i]!=null) {
					if(reset) {
						listad[i].resetText();
					}
				Venta[] v= {listad[i]};
				dtm.addRow(v);
				
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
//					if(lista[i].getU().getDni().equals(MENU.getUactual().getDni())) {
//						lista[i].setBackground(Color.DARK_GRAY);
//					}
					
					if(col==column && fila==row) {
					if(ch!=-1) {
						vactual= nuevalista[i];
					}else {
					i=row;
					vactual=listad[i];
					}
					
				}
				if(ch!=-1) {
					return nuevalista[i];
					
				}
				
				return listad[i];
				}	 
				}
			
				

				table.setModel(dtm);
			
				   
				table.getColumnModel().getColumn(0).setCellRenderer(new Renderer());
				table.getColumnModel().getColumn(0).setPreferredWidth((int) (frame.getWidth()*0.65));
				table.getColumnModel().getColumn(0).setMaxWidth((int) (frame.getWidth()*0.65));
				
				
				
				table.setRowHeight((int) (frame.getHeight()*0.20));
				if(js==null) {
				js=new JScrollPane(table);
				  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				  js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				  js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				  js.getVerticalScrollBar().setUnitIncrement(18);
				  panel_3.add(js);
				  PanelC = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, panel_2, panel_3);
				  panel.add(PanelC, BorderLayout.CENTER);
				}

	}
			private void cargarListaBD() throws MalformedURLException {
				Connection con = BD.initBD("todoCoches.db",true);
				BD.borrarTabla(con, "Coche");
				BD.borrarTabla(con, "Usuario");
				BD.borrarTabla(con, "Venta");
				BD.crearTablas(con);
				BD.rellenarTablas(con);
				lista=BD.BDaMapa(con);
				BD.closeBD(con);
				

			}
			private Venta[] recomendacionRecursiva(ArrayList<Coche> compras, Venta[] listaActual, Venta[] nuevalista,int indiceCompra,int indiceLista,int indiceNueva,HashSet<Coche> repetidos) {
			
				
				if(compras==null || indiceCompra==compras.size() || indiceNueva == nuevalista.length|| compras.get(indiceCompra)==null ) {
					return nuevalista;
				}
				System.out.println(indiceLista+","+listaActual.length);
				if(indiceLista==listaActual.length || listaActual[indiceLista]==null) {
					
					return recomendacionRecursiva(compras, listaActual, nuevalista, indiceCompra+1,0,indiceNueva, repetidos);
				}

				if(compras.get(indiceCompra).getAnio()==listaActual[indiceLista].getC().getAnio() && !listaActual[indiceLista].getU().getDni().equals(uactual.getDni())&& !repetidos.contains(listaActual[indiceLista].getC())) {
					
					nuevalista[indiceNueva]=listaActual[indiceLista];
					nuevalista[indiceNueva].setText("Porque has comprado previamente un coche de "+compras.get(indiceCompra).getAnio());
					repetidos.add(listaActual[indiceLista].getC());
					return recomendacionRecursiva(compras, listaActual, nuevalista, indiceCompra,indiceLista+1,indiceNueva+1, repetidos);
				}else if(compras.get(indiceCompra).getMarca().equals(listaActual[indiceLista].getC().getMarca())&& !listaActual[indiceLista].getU().getDni().equals(uactual.getDni())&& !repetidos.contains(listaActual[indiceLista].getC())) {
					nuevalista[indiceNueva]=listaActual[indiceLista];
					nuevalista[indiceNueva].setText("Porque has comprado previamente un "+listaActual[indiceLista].getC().getMarca());
					repetidos.add(listaActual[indiceLista].getC());
					return recomendacionRecursiva(compras, listaActual, nuevalista, indiceCompra,indiceLista+1,indiceNueva+1, repetidos);	
					
				}
				else if(compras.get(indiceCompra).getKilometros()==listaActual[indiceLista].getC().getKilometros()&& !listaActual[indiceLista].getU().getDni().equals(uactual.getDni()) && !repetidos.contains(listaActual[indiceLista].getC())) {
					
					nuevalista[indiceNueva]=listaActual[indiceLista];
					nuevalista[indiceNueva].setText("Porque has comprado previamente un coche con "+listaActual[indiceLista].getC().getKilometros()+" kms");
					repetidos.add(listaActual[indiceLista].getC());
					return recomendacionRecursiva(compras, listaActual, nuevalista, indiceCompra,indiceLista+1,indiceNueva+1, repetidos);
				}
				
				else {
					
					return recomendacionRecursiva(compras, listaActual, nuevalista, indiceCompra,indiceLista+1, indiceNueva, repetidos);
				}
				
				
			}

		
}
