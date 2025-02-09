package javabean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente2 {
	
	// ATTRIBUTES
	private String idCliente;
	private String nombre;
	private String email;
	private LocalDate createdAt;
	private DireccionCliente direccion;
	private ArrayList<TarjetaBancaria> tarjeta = new ArrayList<>();
	// GETTERS & SETTERS
	public ArrayList<TarjetaBancaria> getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(ArrayList<TarjetaBancaria> tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public DireccionCliente getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionCliente direccion) {
		this.direccion = direccion;
	}

	// HASH CODE & EQUALS (CREATED BY PK IN DB)
	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cliente2)) {
			return false;
		}
		Cliente2 other = (Cliente2) obj;
		return Objects.equals(idCliente, other.idCliente);
	}
	// TO STRING (FOR TESTING)
	@Override
	public String toString() {
		return "Cliente2 [idCliente=" + idCliente + ", nombre=" + nombre + ", email=" + email + ", createdAt="
				+ createdAt + ", direccion=" + direccion + ", tarjeta=" + tarjeta + "]";
	}
	// CONSTRUCTOR OVERLOADED & SIMPLY
	public Cliente2() {
		super();
	}
	public Cliente2(String idCliente, String nombre, String email, LocalDate createdAt, DireccionCliente direccion,
			ArrayList<TarjetaBancaria> tarjeta) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
		this.createdAt = createdAt;
		this.direccion = direccion;
		this.tarjeta = tarjeta;
	}
}
