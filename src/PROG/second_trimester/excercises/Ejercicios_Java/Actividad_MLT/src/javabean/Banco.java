package javabean;

import java.util.Objects;

public class Banco {

	// ATTRIBUTES
	private int codigo;
	private String nombre;
	private Pais paisOpera;
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
	public Pais getPaisOpera() {
		return paisOpera;
	}
	public void setPaisOpera(Pais paisOpera) {
		this.paisOpera = paisOpera;
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
		if (!(obj instanceof Banco)) {
			return false;
		}
		Banco other = (Banco) obj;
		return codigo == other.codigo;
	}
	// TO STRING (FOR TESTING)
	@Override
	public String toString() {
		return "Banco [codigo=" + codigo + ", nombre=" + nombre + ", paisOpera=" + paisOpera + "]";
	}
	// CONSTRUCTOR OVERLOADED & SIMPLY
	public Banco(int codigo, String nombre, Pais paisOpera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.paisOpera = paisOpera;
	}
	public Banco() {
		super();
	}
}
