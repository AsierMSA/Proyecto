
public class Coche {
	private String modelo;
	private String marca;
	private int puertas;
	private int kilometros;
	private int anio;
	private int potencia;
	private String foto;
	public Coche(String modelo, String marca, int puertas, int kilometros, int anio, int potencia, String foto) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.puertas = puertas;
		this.kilometros = kilometros;
		this.anio = anio;
		this.potencia = potencia;
		this.foto=foto;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPuertas() {
		return puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	@Override
	public String toString() {
		return "Coche [modelo=" + modelo + ", marca=" + marca + ", puertas=" + puertas + ", kilometros=" + kilometros
				+ ", anio=" + anio + ", potencia=" + potencia + "]";
	}
	
	
}
