
public class UsuarioAdmin extends Usuario {


	public UsuarioAdmin(String dni, String fechaNacimiento, String nombre, String contrasenia, String ciudad,String foto,Boolean admin) {
		super(dni, fechaNacimiento, nombre, contrasenia, ciudad, foto, admin);

		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "UsuarioAdmin [getDni()=" + getDni()
				+ ", getFechaNacimiento()=" + getFechaNacimiento() + ", getNombre()=" + getNombre()
				+ ", getContrasenia()=" + getContrasenia() + ", getCiudad()=" + getCiudad() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	
	
}
