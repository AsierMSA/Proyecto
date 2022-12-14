public class Usuario{
	private String dni;
	private String fechaNacimiento;
	private String nombre;
	private String contrasenia;
	private String ciudad;
	protected String foto;
	private int cartera;
	private Boolean admin;
	public Usuario(String dni, String fechaNacimiento, String nombre, String contrasenia, String ciudad,String foto,int cartera,Boolean admin) {
		super();
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.ciudad = ciudad;
		this.foto=foto;
		this.setAdmin(admin);
		this.setCartera(cartera);

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
				+ contrasenia + ", admin="  + ", ciudad=" + ciudad + "]";
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public int getCartera() {
		return cartera;
	}
	public void setCartera(int cartera) {
		this.cartera = cartera;
	}

	
	
}