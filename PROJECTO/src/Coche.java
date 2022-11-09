
public class Coche {
	private String modelo;
	private String marca;
	private int puertas;
	private int kilometros;
	private int anio;
	private int potencia;
	public Coche(String modelo, String marca, int puertas, int kilometros, int anio, int potencia) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.puertas = puertas;
		this.kilometros = kilometros;
		this.anio = anio;
		this.potencia = potencia;
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
	
	
}
