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
	public Venta(Coche c, Usuario u) {
		this.c=c;
		this.u=u;
		this.setSize(200, 50);
		this.imagen=new ImageIcon(c.getFoto());
		this.icono= new ImageIcon(this.imagen.getImage().getScaledInstance(100, this.getHeight(), Image.SCALE_DEFAULT));
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
