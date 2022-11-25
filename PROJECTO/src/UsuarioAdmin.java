
public class UsuarioAdmin extends Usuario {

	private boolean admin;

	public UsuarioAdmin(String dni, String fechaNacimiento, String nombre, String contrasenia, String ciudad, boolean admin) {
		super(dni, fechaNacimiento, nombre, contrasenia, ciudad);
		this.admin=admin;
		// TODO Auto-generated constructor stub
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "UsuarioAdmin [admin=" + admin + ", isAdmin()=" + isAdmin() + ", getDni()=" + getDni()
				+ ", getFechaNacimiento()=" + getFechaNacimiento() + ", getNombre()=" + getNombre()
				+ ", getContrasenia()=" + getContrasenia() + ", getCiudad()=" + getCiudad() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	
	
}
