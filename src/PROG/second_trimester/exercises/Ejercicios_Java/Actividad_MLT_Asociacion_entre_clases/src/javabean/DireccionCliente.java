package javabean;

import java.util.Objects;

public class DireccionCliente {
	
	// ATTRIBUTES
	private String direccion;
	private String localidad;
	private String provincia;
	private Pais pais;
	// GETTERS & SETTERS
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	// HASH CODE & EQUALS (CREATED BY PK IN DB)
	@Override
	public int hashCode() {
		return Objects.hash(direccion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DireccionCliente)) {
			return false;
		}
		DireccionCliente other = (DireccionCliente) obj;
		return Objects.equals(direccion, other.direccion);
	}
	// TO STRING (FOR TESTING)
	@Override
	public String toString() {
		return "DireccionCliente [direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", pais=" + pais + "]";
	}
	// CONSTRUCTOR OVERLOADED & SIMPLY
	public DireccionCliente(String direccion, String localidad, String provincia, Pais pais) {
		super();
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
	}
	public DireccionCliente() {
		super();
	}
}
