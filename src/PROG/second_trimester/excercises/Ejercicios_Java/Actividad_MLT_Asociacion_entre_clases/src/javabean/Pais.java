package javabean;

import java.util.Objects;

public class Pais {
	
	// ATTRIBUTES
	private int codigo;
	private String nombre;
	// GETTERS & SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// HASH CODE & EQUALS (CREATED BY PK IN DB)
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pais)) {
			return false;
		}
		Pais other = (Pais) obj;
		return codigo == other.codigo;
	}
	// TO STRING (FOR TESTING)
	@Override
	public String toString() {
		return "Pais [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	// CONSTRUCTOR OVERLOADED & SIMPLY
	public Pais(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public Pais() {
		super();
	}
}
