import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

public class VentanaEstadistica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEstadistica frame = new VentanaEstadistica();
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
	public VentanaEstadistica() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		contentPane.add(panel,BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 Map<String,Integer> mapa= new HashMap<String,Integer>();
		 for(Venta v: MENU.getLista()) {
		     if(!mapa.containsKey(v.getU().getNombre())) {
		         mapa.put(v.getU().getNombre(), v.getVistas());
		     }else {
		         mapa.replace(v.getU().getNombre(), mapa.get(v.getU().getNombre())+ v.getVistas());
		     }
		 } 
		for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
		    dataset.addValue(entry.getValue(), "Visit", entry.getKey());
		}
		JFreeChart chart = ChartFactory.createBarChart("Visitas por usuario", "Usuarios", "Visitas", dataset);
		NumberAxis yAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
		yAxis.setTickUnit(new NumberTickUnit(1));
		CategoryAxis xAxis = chart.getCategoryPlot().getDomainAxis();
		xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		
		ChartPanel cpanel = new ChartPanel(chart);
		cpanel.setPreferredSize(new Dimension(contentPane.getWidth(), contentPane.getHeight()));
		panel.add(cpanel);
	
		
	}

}
