package javabean;

public class Caballo extends AbstractAnimal{
	
	private double velocidad;
	
	

	public Caballo(int matricula, String nombreCientifico, int numeroPatas, double velocidad) {
		super(matricula, nombreCientifico, numeroPatas);
		this.velocidad = velocidad;
	}
	

	public Caballo() {
		super();
	}


	@Override
	public void saludar() {
		System.out.println("soy caballo de carreras y corro tel");
		
	}

	@Override
	public void sonido() {
		System.out.println("Yo RELINCHO!!!");
		
	}


	public double getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}


	@Override
	public String toString() {
		return "Caballo [velocidad=" + velocidad + ", matricula=" + matricula + ", nombreCientifico=" + nombreCientifico
				+ ", numeroPatas=" + numeroPatas + ", getVelocidad()=" + getVelocidad() + ", getNombreCientifico()="
				+ getNombreCientifico() + ", getNumeroPatas()=" + getNumeroPatas() + ", getMatricula()="
				+ getMatricula() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + "]";
	}
	
	

}
