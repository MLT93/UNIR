package modelo.dao;

import java.util.List;

import modelo.javabeans.Cliente;

public interface ClienteDao extends CrudGenerico<Cliente, String> {
	
	String exportar(String nombreFichero);
	List<Cliente> importar(String nombreFichero);

}
