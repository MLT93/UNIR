package javabean;

import java.util.Objects;

public class TarjetaBancaria {
	
	// ATTRIBUTES
	private Long numero;
	private Integer year;
	private Integer mes;
	private Integer cvv;
	private String titularTarjeta;
	private Banco banco;
	// GETTERS & SETTERS
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getCvv() {
		return cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	public String getTitularTarjeta() {
		return titularTarjeta;
	}
	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	// HASH CODE & EQUALS (CREATED BY PK IN DB)
	@Override
	public int hashCode() {
		return Objects.hash(cvv, numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TarjetaBancaria)) {
			return false;
		}
		TarjetaBancaria other = (TarjetaBancaria) obj;
		return cvv == other.cvv && numero == other.numero;
	}
	// TO STRING (FOR TESTING)
	@Override
	public String toString() {
		return "TarjetaBancaria [numero=" + numero + ", year=" + year + ", mes=" + mes + ", cvv=" + cvv
				+ ", titularTarjeta=" + titularTarjeta + ", banco=" + banco + "]";
	}
	// CONSTRUCTOR OVERLOADED & SIMPLY
	public TarjetaBancaria(long numero, Integer year, Integer mes, Integer cvv, String titularTarjeta, Banco banco) {
		super();
		this.numero = numero;
		this.year = year;
		this.mes = mes;
		this.cvv = cvv;
		this.titularTarjeta = titularTarjeta;
		this.banco = banco;
	}
	public TarjetaBancaria() {
		super();
	}
}
