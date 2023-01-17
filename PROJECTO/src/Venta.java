import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Venta extends JLabel {

	/**
	 * 
	 */
	private ImageIcon imagen;
	private ImageIcon icono;
	private static final long serialVersionUID = 1L;
	private Coche c;
	private Usuario u;
	private static int x=350;
	private static int y=185;
	private String titulo;
	URL url;
	private int vistas;
	private int dinero;
	public Venta(Coche c, Usuario u,String d, int dinero,int vistas) throws MalformedURLException {
		this.c=c;
		this.u=u;
		this.setVistas(vistas);
		this.setTitulo(d);
		this.setSize(x,y);
		this.setDinero(dinero);
		if(BD.esURL(c.getFoto())) {
			url = new URL(c.getFoto());
			this.icono = new ImageIcon(url);
			this.imagen = new ImageIcon(url);
		}else {
		
		if(!c.getFoto().equals("SIN IMAGEN")) {
		
			this.imagen=new ImageIcon(c.getFoto());
		
		}else {
		
		this.imagen=new ImageIcon("src\\FOTOS\\default.png");
		c.setFoto("src\\FOTOS\\default.png");
		}
		
		}
		this.icono= new ImageIcon(this.imagen.getImage().getScaledInstance((int) (this.getWidth()), (int) (this.getHeight()), Image.SCALE_DEFAULT));
		this.setIcon(this.icono);
		this.setText("<html><font size='6'><font face='SansSerif'>&emsp;"+this.getTitulo()+"</font></font><br><br>&emsp;&emsp;Descripcion&emsp;&emsp;&emsp;&emsp;&emsp;"+this.dinero+"€</html>");
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		
		this.setVerticalTextPosition(SwingConstants.NORTH);
		 Border border = BorderFactory.createCompoundBorder(
	                new RoundedBorder(20, 20, Color.BLUE),
	                BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        setBorder(border);
	}
	public ImageIcon getImagen() {
		return imagen;
	}
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	public Coche getC() {
		return c;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		Venta.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		Venta.y = y;
	}
	public void setC(Coche c) {
		this.c = c;
	}
	public Usuario getU() {
		return u;
	}
	public void setU(Usuario u) {
		this.u = u;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public int getVistas() {
		return vistas;
	}
	public void setVistas(int vistas) {
		this.vistas = vistas;
	}
	
}
class RoundedBorder implements Border {

    private final int arcWidth;
    private final int arcHeight;
    private final Color color;

    public RoundedBorder(int arcWidth, int arcHeight, Color color) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.color = color;
    }
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape border = new RoundRectangle2D.Double(x, y, width - 1, height - 1, arcWidth, arcHeight);
        g2.setColor(color);
        g2.draw(border);
        g2.dispose();
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(arcHeight, arcWidth, arcHeight, arcWidth);
    }

}

