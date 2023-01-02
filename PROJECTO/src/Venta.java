import java.awt.Font;
import java.awt.Image;

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
	public Venta(Coche c, Usuario u,String d) {
		this.c=c;
		this.u=u;
		this.setTitulo(d);
		this.setSize(x,y);
		this.imagen=new ImageIcon(c.getFoto());
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
