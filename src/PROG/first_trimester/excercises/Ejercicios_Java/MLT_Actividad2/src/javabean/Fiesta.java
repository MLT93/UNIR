/**
 * Package javabean (without main class)
 */
package javabean;

/**
 * Class Fiesta
 */
public class Fiesta {

	/**
	 * Attribute
	 */
	// Al ser "private" es únicamente accesible desde la propia clase
	private String tipoFiesta;
	private String drieccion;
	private int numBocadillos;
	private int numBebidas;
	private int numInvitados;
	private String fecha;
	private String hora;

	/**
	 * Constructor
	 */
	public Fiesta() {
		super();
	}

	/**
	 * Constructor Overloaded
	 */
	public Fiesta(String tipoFiesta, String drieccion, int bocadillos, int bebidas, int invitados, String fecha,
			String hora) {
		super();
		this.tipoFiesta = tipoFiesta;
		this.drieccion = drieccion;
		this.numBocadillos = bocadillos;
		this.numBebidas = bebidas;
		this.numInvitados = invitados;
		this.fecha = fecha;
		this.hora = hora;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Fiesta [tipoFiesta=" + tipoFiesta + ", drieccion=" + drieccion + ", numBocadillos=" + numBocadillos
				+ ", numBebidas=" + numBebidas + ", numInvitados=" + numInvitados + ", fecha=" + fecha + ", hora="
				+ hora + ", getTipoFiesta()=" + getTipoFiesta() + ", getDrieccion()=" + getDrieccion()
				+ ", getNumBocadillos()=" + getNumBocadillos() + ", getNumBebidas()=" + getNumBebidas()
				+ ", getNumInvitados()=" + getNumInvitados() + ", getFecha()=" + getFecha() + ", getHora()=" + getHora()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	/**
	 * Getters & Setters
	 */
	// Al ser "protected" sólo se podrá acceder a ellos desde la própia class y de
	// las clases hijas
	protected String getTipoFiesta() {
		return tipoFiesta;
	}

	protected void setTipoFiesta(String tipoFiesta) {
		this.tipoFiesta = tipoFiesta;
	}

	protected String getDrieccion() {
		return drieccion;
	}

	protected void setDrieccion(String drieccion) {
		this.drieccion = drieccion;
	}

	protected int getNumBocadillos() {
		return numBocadillos;
	}

	protected void setNumBocadillos(int numBocadillos) {
		this.numBocadillos = numBocadillos;
	}

	protected int getNumBebidas() {
		return numBebidas;
	}

	protected void setNumBebidas(int numBebidas) {
		this.numBebidas = numBebidas;
	}

	protected int getNumInvitados() {
		return numInvitados;
	}

	protected void setNumInvitados(int numInvitados) {
		this.numInvitados = numInvitados;
	}

	protected String getFecha() {
		return fecha;
	}

	protected void setFecha(String fecha) {
		this.fecha = fecha;
	}

	protected String getHora() {
		return hora;
	}

	protected void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * Methods
	 */
	// Al ser "public" se puede acceder desde la class, clases hijas e instancias
	public int invitar() {
		return this.getNumInvitados() + 1;
	}

	// Para calcular el coste total de la fiesta necesitaremos el total de bebidas y
	// el total de bocadillos
	// Al tener "protected" los getters & setters, se crean las funciones públicas
	// que me permiten acceder a la info
	public int bebidasConsumidas(int totBebidas) {
		this.setNumBebidas(totBebidas);
		return this.getNumBebidas();
	}

	public int bocadillosComidos(int totBocadillos) {
		this.setNumBocadillos(totBocadillos);
		return this.getNumBocadillos();
	}

	public int cancelarInvitacion() {
		return this.getNumInvitados() - 1;
	}

	public String precioFiesta() {
		int precioInvitado = 5;
		int precioBebida = 2;
		int precioBocadillo = 3;

		int a = this.getNumInvitados() * precioInvitado;
		int b = this.getNumBocadillos() * precioBocadillo;
		int c = this.getNumBebidas() * precioBebida;
		int tot = a + b + c;

		return tot + "€";
	}

	// Muestro los datos de la fiesta
	public void show() {
		System.out.println("Número de invitados: " + this.getNumInvitados());
		System.out.println("Número de bebidas: " + this.getNumBebidas());
		System.out.println("Número de bocadillos: " + this.getNumBocadillos());
		System.out.println("Precio de la fiesta: " + this.precioFiesta());
	}

	/**
	 * Methods Overloaded
	 */
	public int invitar(int cantidad) {
		if (cantidad > 0) {
			int totCantidad = this.getNumInvitados() + cantidad;
			this.setNumInvitados(totCantidad);
		}
		return this.getNumInvitados();
	}

	public int cancelarInvitacion(int cantidad) {
		if (cantidad > 0) {
			int totCantidad = this.getNumInvitados() - cantidad;
			this.setNumInvitados(totCantidad);
		}
		return this.getNumInvitados();
	}

}
