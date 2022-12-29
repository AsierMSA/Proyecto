import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
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
	 */
	public VentanaVenta2(Venta v) {
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
		ImageIcon i=new ImageIcon(v.getC().getFoto());
		ImageIcon ic= new ImageIcon(i.getImage().getScaledInstance(250, (int) (jl.getHeight()*1.25), Image.SCALE_DEFAULT));
		jl.setIcon(ic);
		pnl_medio.add(jl);
		
		JLabel lblNewLabel = new JLabel("<html><font size='6'><font face='SansSerif'>&emsp;"+v.getC().getMarca()+" "+v.getC().getModelo()+"</font></font><br><br>&emsp;&emsp;Kilometros:&emsp;"+v.getC().getKilometros()+"<br><br>&emsp;&emsp;Año de compra:"+v.getC().getAnio()+"<br><br>&emsp;&emsp;Potencia: "+v.getC().getPotencia()+"cv"+"<br><br>&emsp;&emsp;Num. Puertas: "+v.getC().getPuertas()+"<br><br>&emsp;&emsp;Vendedor: "+v.getU().getNombre()+"</html>");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		JLabel label=new JLabel();
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		ImageIcon i1=new ImageIcon(v.getU().getFoto());
		ImageIcon ic1= new ImageIcon(i1.getImage().getScaledInstance(100, (int) (jl.getHeight()*0.75), Image.SCALE_DEFAULT));
		label.setIcon(ic1);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel pnl_oeste = new JPanel();
		contentPane.add(pnl_oeste, BorderLayout.WEST);
		
		pnl_abajo = new JPanel();
		pnl_abajo.setLayout(new BorderLayout(1,3));
		pnl_abajo.add(label,BorderLayout.WEST);
		contentPane.add(pnl_abajo, BorderLayout.SOUTH);
		
		JButton btn_salir = new JButton("SALIR");
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		pnl_abajo.add(btn_salir,BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("COMPRAR\r\n\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MENU.getLista();
			Venta[] nv=new Venta[20];
			int j=0;
			for(int i=0;i<MENU.getLista().length;i++) {
				if(MENU.getLista()[i]!=null) {
				if(!MENU.getLista()[i].equals(v)) {
					nv[j]=MENU.getLista()[i];
					j++;
				}
				}
			}
			
			MENU.setLista(nv);
			
			}
		});
		pnl_abajo.add(btnNewButton,BorderLayout.CENTER);
		
		JPanel pnl_este = new JPanel();
		contentPane.add(pnl_este, BorderLayout.EAST);
		contentPane.add(pnl_medio, BorderLayout.EAST);
		}
		
		


	}

}
