package javabean;

import java.util.Objects;

public class Animal {
	protected int matricula;
	protected String nombreCientifico;
	protected int numeroPatas;
	
	public void saludar() {
		System.out.println("Hola soy un animal y mi nombre es : " + nombreCientifico);
	}
	
	public void sonido() {
		System.out.println("Y yo que se que sonido emito soy generico");
	}

	
	public Animal(int matricula, String nombreCientifico, int numeroPatas) {
		super();
		this.matricula = matricula;
		this.nombreCientifico = nombreCientifico;
		this.numeroPatas = numeroPatas;
	}
	public Animal() {
		super();
	}
	public String getNombreCientifico() {
		return nombreCientifico;
	}
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
	public int getNumeroPatas() {
		return numeroPatas;
	}
	public void setNumeroPatas(int numeroPatas) {
		this.numeroPatas = numeroPatas;
	}
	
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal other =   (Animal) obj;
		return matricula == other.matricula;
	}
	
	
	@Override
	public String toString() {
		return "Animal [matricula=" + matricula + ", nombreCientifico=" + nombreCientifico + ", numeroPatas="
				+ numeroPatas + "]";
	}
	
}
