public class Usuario{
	private String dni;
	private String fechaNacimiento;
	private String nombre;
	private String contrasenia;
	private boolean admin;
	private String ciudad;
	public Usuario(String dni, String fechaNacimiento, String nombre, String contrasenia, String ciudad) {
		super();
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.ciudad = ciudad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", contrasenia="
				+ contrasenia + ", admin=" + admin + ", ciudad=" + ciudad + "]";
	}
	
	
}