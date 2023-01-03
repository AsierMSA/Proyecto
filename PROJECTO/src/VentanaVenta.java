import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaVenta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_modelo;
	private JTextField txt_marca;
	private JTextField txt_puertas;
	private JTextField txt_anios;
	private JTextField txt_kilometros;
	private JTextField txt_potencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVenta frame = new VentanaVenta();
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
	public VentanaVenta() {
		
		setTitle("ANIADIR COCHE AL MERCADO");
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnl_centro = new JPanel();
		contentPane.add(pnl_centro, BorderLayout.CENTER);
		pnl_centro.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lbl_modelo = new JLabel("MODELO");
		pnl_centro.add(lbl_modelo);
		
		txt_modelo = new JTextField();
		pnl_centro.add(txt_modelo);
		txt_modelo.setColumns(10);
		
		JLabel lbl_marca = new JLabel("MARCA");
		pnl_centro.add(lbl_marca);
		
		txt_marca = new JTextField();
		pnl_centro.add(txt_marca);
		txt_marca.setColumns(10);
		
		JLabel lbl_puertas = new JLabel("PUERTAS");
		pnl_centro.add(lbl_puertas);
		
		txt_puertas = new JTextField();
		pnl_centro.add(txt_puertas);
		txt_puertas.setColumns(10);
		
		JLabel lbl_potencia = new JLabel("POTENCIA");
		pnl_centro.add(lbl_potencia);
		
		txt_potencia = new JTextField();
		pnl_centro.add(txt_potencia);
		txt_potencia.setColumns(10);
		
		JLabel lbl_anios = new JLabel("ANIOS");
		pnl_centro.add(lbl_anios);
		
		txt_anios = new JTextField();
		pnl_centro.add(txt_anios);
		txt_anios.setColumns(10);
		
		JLabel lbl_kilometros = new JLabel("KILOMETROS");
		pnl_centro.add(lbl_kilometros);
		
		txt_kilometros = new JTextField();
		pnl_centro.add(txt_kilometros);
		txt_kilometros.setColumns(10);
		
		JPanel pnl_oeste = new JPanel();
		contentPane.add(pnl_oeste, BorderLayout.WEST);
		
		JPanel pnl_norte = new JPanel();
		contentPane.add(pnl_norte, BorderLayout.NORTH);
		
		JLabel lbl_aniadirCoche = new JLabel("ANIADIR COCHE");
		pnl_norte.add(lbl_aniadirCoche);
		
		JPanel pnl_sur = new JPanel();
		contentPane.add(pnl_sur, BorderLayout.SOUTH);
		JLabel jl=new JLabel("SIN IMAGEN");
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		pnl_sur.add(btn_cancelar);
		
		JButton btnNewButton_1 = new JButton("ANIADIR");
		pnl_sur.add(btnNewButton_1);
		
		JPanel pnl_este = new JPanel();
		contentPane.add(pnl_este, BorderLayout.EAST);
		JButton btnNewButton = new JButton("Aniadir Foto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnl_sur.add(btnNewButton);
		pnl_sur.add(jl);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
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
			       	jl.setText(chooser.getSelectedFile().getName());
			    }
			    
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txt_modelo.getText().equals("") || txt_marca.getText().equals("") || txt_puertas.getText().equals("")
						|| txt_potencia.getText().equals("")  || txt_kilometros.getText().equals("") || txt_anios.getText().equals("")) {
					JOptionPane.showMessageDialog(btnNewButton, "Rellena todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE, null);
				}else {
					
					try {
						Coche c=new Coche(txt_modelo.getText(),txt_marca.getText(), Integer.parseInt(txt_puertas.getText()),
								Integer.parseInt(txt_kilometros.getText()),Integer.parseInt(txt_potencia.getText()),Integer.parseInt(txt_anios.getText()),jl.getText());
						Venta v=new Venta(c,MENU.getUactual(),"");
						Venta[] nuevalista=new Venta[20];
						for(int i=0;i<MENU.getLista().length+1;i++) {

							if(i==MENU.getLista().length) {
								nuevalista[i]=v;
		
							}else {
								nuevalista[i]=MENU.getLista()[i];
							}
						}
						
						MENU.setLista(nuevalista);
						dispose();
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}
				
			}
		});
	}

}
