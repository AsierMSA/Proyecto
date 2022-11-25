
public class UsuarioRegular extends Usuario{
	
	private boolean regular;

	public UsuarioRegular(String dni, String fechaNacimiento, String nombre, String contrasenia, String ciudad, boolean regular) {
		super(dni, fechaNacimiento, nombre, contrasenia, ciudad);
		this.regular=regular;
		// TODO Auto-generated constructor stub
	}

	public boolean isRegular() {
		return regular;
	}

	public void setRegular(boolean regular) {
		this.regular = regular;
	}

	@Override
	public String toString() {
		return "UsuarioRegular [regular=" + regular + ", isRegular()=" + isRegular() + ", getDni()=" + getDni()
				+ ", getFechaNacimiento()=" + getFechaNacimiento() + ", getNombre()=" + getNombre()
				+ ", getContrasenia()=" + getContrasenia() + ", getCiudad()=" + getCiudad() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	
}
