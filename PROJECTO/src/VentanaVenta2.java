import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class VentanaVenta2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 450, 300);
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
		System.out.println(v.getC().getFoto());
		ImageIcon ic= new ImageIcon(i.getImage().getScaledInstance(200, jl.getHeight(), Image.SCALE_DEFAULT));
		jl.setIcon(ic);
		pnl_medio.add(jl);
		}
		
		
		JPanel pnl_oeste = new JPanel();
		contentPane.add(pnl_oeste, BorderLayout.WEST);
		
		JPanel pnl_abajo = new JPanel();
		contentPane.add(pnl_abajo, BorderLayout.SOUTH);
		
		JButton btn_salir = new JButton("SALIR");
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		pnl_abajo.add(btn_salir);
		
		JButton btnNewButton = new JButton("COMPRAR\r\n\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnl_abajo.add(btnNewButton);
		
		JPanel pnl_este = new JPanel();
		contentPane.add(pnl_este, BorderLayout.EAST);
		contentPane.add(pnl_medio, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
