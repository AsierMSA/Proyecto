import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class VentanaVenta2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JPanel pnl_abajo;
	private JPanel botones;
	private JButton btnNewButton;
	private Venta venta;
	int confirmado;
	private static Venta[] nv;
	boolean editable=false;
	ImageIcon i1;
	static boolean comprado=false;
	private static JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVenta2 frame = new VentanaVenta2(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws MalformedURLException 
	 */
	public VentanaVenta2(Venta v) throws MalformedURLException {
		this.venta=v;
		if(MENU.getUactual().getDni().equals(v.getU().getDni())) {
			editable=true;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnl_arriba = new JPanel();
		contentPane.add(pnl_arriba, BorderLayout.NORTH);
		
		JList lista = new JList();
		pnl_arriba.add(lista);
		
		JPanel pnl_medio = new JPanel();
		contentPane.add(pnl_medio, BorderLayout.CENTER);
		if(v!=null) {
		JLabel jl=new JLabel();
		jl.setSize(450, 100);
		ImageIcon i=v.getImagen();
		ImageIcon ic= new ImageIcon(i.getImage().getScaledInstance(250, (int) (jl.getHeight()*1.25), Image.SCALE_DEFAULT));
		jl.setIcon(ic);
		pnl_medio.add(jl);
		
		lblNewLabel = new JLabel("<html><font size='6'><font face='SansSerif'>&emsp;"+v.getC().getMarca()+" "+v.getC().getModelo()+"</font></font><br><br>&emsp;&emsp;Kilometros:&emsp;"+v.getC().getKilometros()+"<br><br>&emsp;&emsp;Año de compra:"+v.getC().getAnio()+"<br><br>&emsp;&emsp;Potencia: "+v.getC().getPotencia()+"cv"+"<br><br>&emsp;&emsp;Num. Puertas: "+v.getC().getPuertas()+"<br><br>&emsp;&emsp;Vendedor: "+v.getU().getNombre()+"</html>");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		JLabel label=new JLabel();
		
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		i1=new ImageIcon(v.getU().getFoto());
		ImageIcon ic1= new ImageIcon(i1.getImage().getScaledInstance(100, (int) (jl.getHeight()*0.75), Image.SCALE_DEFAULT));
		label.setPreferredSize(new Dimension(150,(int) (jl.getHeight()*0.75)));
		label.setIcon(ic1);
		label.setHorizontalAlignment(JLabel.RIGHT);

		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel pnl_oeste = new JPanel();
		contentPane.add(pnl_oeste, BorderLayout.WEST);
		
		pnl_abajo = new JPanel();
		pnl_abajo.setLayout(new BorderLayout(1,3));
		pnl_abajo.add(label,BorderLayout.WEST);
		contentPane.add(pnl_abajo, BorderLayout.SOUTH);
		
		botones=new JPanel();
		JLabel vistas = new JLabel();
		
		ImageIcon i2=new ImageIcon("src//FOTOS//ojo.png");
		ImageIcon ic2= new ImageIcon(i2.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		vistas.setIcon(ic2);
		JButton btn_salir = new JButton("SALIR");
		btn_salir.setPreferredSize(new Dimension(100, 30));
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	
		if(editable) {
			btnNewButton=new JButton("BORRAR");
			if(comprado) {
			lblNewLabel.setText("<html><font size='6'><font face='SansSerif'>&emsp;"+v.getC().getMarca()+" "+v.getC().getModelo()+"</font></font><br><br>&emsp;&emsp;Kilometros:&emsp;"+v.getC().getKilometros()+"<br><br>&emsp;&emsp;Año de compra:"+v.getC().getAnio()+"<br><br>&emsp;&emsp;Potencia: "+v.getC().getPotencia()+"cv"+"<br><br>&emsp;&emsp;Num. Puertas: "+v.getC().getPuertas()+"<br><br>&emsp;&emsp;Comprador: "+v.getU().getNombre()+"</html>");
			}
			}
		else {
		btnNewButton = new JButton("COMPRAR\r\n\r\n");
		v.setVistas(v.getVistas()+1);
		
		}
		vistas.setText(v.getVistas()+"");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(editable) {
					confirmado = JOptionPane.showConfirmDialog(
							   
							  contentPane, "¿Estas seguro de que quieres borrarlo?");
				}else {
				confirmado = JOptionPane.showConfirmDialog(
						   
						  contentPane, "¿Estas seguro de que quieres comprarlo?");
				}
						if (JOptionPane.OK_OPTION == confirmado) {
						
							if(BD.comprable(v.getDinero(),editable)) {
								LoggerTodoCoches.logVenta(v, MENU.getUactual());
								comprado=true;
								nv=new Venta[MENU.getLista().length];
								int j=0;
						
						for(int i=0;i<MENU.getLista().length;i++) {
							if(MENU.getLista()[i]!=null) {
							if(!MENU.getLista()[i].equals(venta)) {
								if(!MENU.getLista()[i].getC().equals(venta.getC()) ) {
								nv[j]=MENU.getLista()[i];
								j++;
								}
							}
							}
						}
						Connection con = BD.initBD("todoCoches.db",false);
						BD.borrarVenta(con, v);
					
						}
							else if(editable) {
							
							nv=new Venta[MENU.getLista().length];
							int j=0;
							for(int i=0;i<MENU.getLista().length;i++) {
								if(MENU.getLista()[i]!=null) {
								if(!MENU.getLista()[i].getC().equals(venta.getC()) ) {
									nv[j]=MENU.getLista()[i];
									j++;
								}
								}
							}
						Connection con = BD.initBD("todoCoches.db",false);
						BD.borrarVenta(con, v);
						}
						if(!editable) {
						ArrayList<Coche> cmp=BD.getMapaCompras().get(MENU.getUactual().getDni());
						cmp.add(v.getC());
						HashMap<String, ArrayList<Coche>> mapa=BD.getMapaCompras();
						mapa.replace(MENU.getUactual().getDni(),cmp);
						BD.setMapaCompras(mapa);
						MENU.setLista(nv);
						}else {
							MENU.setLista(nv);
							int pos=0;
							Venta[] nuevo= new Venta[MENU.getLista().length];
							for(Venta v: nv) {
								if(v!=null) {
								if(v.getU().getDni().equals(MENU.getUactual().getDni())) {
									nuevo[pos]=v;
									pos++;
								}
								}
							}
							ArrayList<Coche> cochesu=BD.getMapaVentas().get(MENU.getUactual().getDni());
							cochesu.remove(v.getC());
							HashMap<String, ArrayList<Coche>> mapa = BD.getMapaVentas();
							mapa.replace(MENU.getUactual().getDni(), cochesu);
							BD.setMapaVentas(mapa);
							VentanaPerfil.crearTabla(VentanaPerfil.getTable1(), nuevo, false);
						}
				
						dispose();
						BD.guardaCompras();
						
							
						}
			}
		});
		btnNewButton.setPreferredSize(new Dimension(200, 30));
		botones.add(btnNewButton,BorderLayout.CENTER);
		botones.add(btn_salir,BorderLayout.EAST);
		botones.add(vistas);
		pnl_abajo.add(botones);
		JPanel pnl_este = new JPanel();
		contentPane.add(pnl_este, BorderLayout.EAST);
		contentPane.add(pnl_medio, BorderLayout.EAST);
		}
		


	}

	public Venta[] getNv() {
		return nv;
	}

	public void setNv(Venta[] nv) {
		VentanaVenta2.nv = nv;
	}
	
	
}
