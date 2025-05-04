package modelo.javabean;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

	// Attributes
    private static final long serialVersionUID = 1L;

    private String cif;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private double facturacionAnual;
    private int numeroEmpledos;

    // Constructor con nada
    public Cliente() {
        super();
    }

    // Constructor con todo
    public Cliente(String cif, String nombre, String apellidos, String domicilio, double facturacionAnual,
            int numeroEmpledos) {
        super();
        this.cif = cif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.facturacionAnual = facturacionAnual;
        this.numeroEmpledos = numeroEmpledos;
    }

    // Getters & Setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public double getFacturacionAnual() {
        return facturacionAnual;
    }

    public void setFacturacionAnual(double facturacionAnual) {
        this.facturacionAnual = facturacionAnual;
    }

    public int getNumeroEmpledos() {
        return numeroEmpledos;
    }

    public void setNumeroEmpledos(int numeroEmpledos) {
        this.numeroEmpledos = numeroEmpledos;
    }

    // Equals & Hash-Code
    @Override
    public int hashCode() {
        return Objects.hash(cif);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) obj;
        return Objects.equals(cif, other.cif);
    }

    // ToString
    @Override
    public String toString() {
        return "Cliente [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio=" + domicilio
                + ", facturacionAnual=" + facturacionAnual + ", numeroEmpledos=" + numeroEmpledos + "]";
    }

}

