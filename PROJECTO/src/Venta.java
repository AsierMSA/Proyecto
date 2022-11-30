import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Venta extends JLabel {

	/**
	 * 
	 */
	private ImageIcon imagen;
	private ImageIcon icono;
	private static final long serialVersionUID = 1L;
	private Coche c;
	private Usuario u;
	private int x=350;
	private int y=100;
	public Venta(Coche c, Usuario u) {
		this.c=c;
		this.u=u;
		this.setSize(x,y);
		this.imagen=new ImageIcon(c.getFoto());
		this.icono= new ImageIcon(this.imagen.getImage().getScaledInstance((int) (this.getWidth()*0.50), this.getHeight(), Image.SCALE_DEFAULT));
		this.setIcon(this.icono);
		this.setText(u.getNombre());
		
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
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
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
}
