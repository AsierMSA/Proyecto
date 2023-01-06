import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
	public Venta(Coche c, Usuario u,String d) throws MalformedURLException {
		this.c=c;
		this.u=u;
		this.setTitulo(d);
		this.setSize(x,y);
		
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
		this.setText("<html><font size='6'><font face='SansSerif'>&emsp;"+this.getTitulo()+"</font></font><br><br>&emsp;&emsp;Descripcion</html>");
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		this.setVerticalTextPosition(SwingConstants.NORTH);
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
}
