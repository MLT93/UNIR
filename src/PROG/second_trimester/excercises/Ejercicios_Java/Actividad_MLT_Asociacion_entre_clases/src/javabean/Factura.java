package javabean;

import java.time.LocalDate;
import java.util.Objects;

public class Factura {
	
	// ATTRIBUTES
	private String codigoFactura;
	private String descripcion;
	private LocalDate fechaFactura;
	private Pedido Pedido;
	// GETTERS & SETTERS
	public String getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(LocalDate fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public Pedido getPedido() {
		return Pedido;
	}
	public void setPedido(Pedido pedido) {
		Pedido = pedido;
	}
	// HASH CODE & EQUALS (CREATED BY PK IN DB)
	@Override
	public int hashCode() {
		return Objects.hash(codigoFactura);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Factura)) {
			return false;
		}
		Factura other = (Factura) obj;
		return Objects.equals(codigoFactura, other.codigoFactura);
	}
	// TO STRING (FOR TESTING)
	@Override
	public String toString() {
		return "Factura [codigoFactura=" + codigoFactura + ", descripcion=" + descripcion + ", fechaFactura="
				+ fechaFactura + ", Pedido=" + Pedido + "]";
	}
	// CONSTRUCTOR OVERLOADED & SIMPLY
	public Factura(String codigoFactura, String descripcion, LocalDate fechaFactura, javabean.Pedido pedido) {
		super();
		this.codigoFactura = codigoFactura;
		this.descripcion = descripcion;
		this.fechaFactura = fechaFactura;
		Pedido = pedido;
	}
	public Factura() {
		super();
	}
}
