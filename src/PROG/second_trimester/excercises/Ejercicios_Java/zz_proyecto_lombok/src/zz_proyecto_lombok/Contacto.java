package zz_proyecto_lombok;

import java.util.Objects;

public class Contacto {
	
	// ATTRIBUTES
	private String nombre;
	private String telefono;
	private String direccion;
	// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	// CONSTRUCTOR OVERLOADED & SIMPLY
	public Contacto(String nombre, String telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public Contacto() {
		super();
	}
	// HASH CODE & EQUALS (CREATED BY PK IN DB)
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Contacto)) {
			return false;
		}
		Contacto other = (Contacto) obj;
		return Objects.equals(nombre, other.nombre);
	}
	// TO STRING (FOR TESTING)
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}

	
}
