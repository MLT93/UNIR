package javabean;

import java.util.Objects;

public abstract class AbstractAnimal {
	/*
	 * 1.- De una clase abstarcta no se pueden hacer new, 
	 * pero si se pueden crear variables
	 * 
	 * 2,- puede declarar una serie de métodos abstracto
	 *         - el que no tiene implementacion
	 * 3.- Un método abstracto obliga a la clase que hereda de él a reescribir ese método
	 */
	protected int matricula;
	protected String nombreCientifico;
	protected int numeroPatas;
	
	public abstract void saludar();
	
	public abstract void sonido();

	
	public AbstractAnimal(int matricula, String nombreCientifico, int numeroPatas) {
		super();
		this.matricula = matricula;
		this.nombreCientifico = nombreCientifico;
		this.numeroPatas = numeroPatas;
	}
	public AbstractAnimal() {
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
		if (!(obj instanceof AbstractAnimal))
			return false;
		AbstractAnimal other =   (AbstractAnimal) obj;
		return matricula == other.matricula;
	}
	
	
	@Override
	public String toString() {
		return "Animal [matricula=" + matricula + ", nombreCientifico=" + nombreCientifico + ", numeroPatas="
				+ numeroPatas + "]";
	}
	
}
