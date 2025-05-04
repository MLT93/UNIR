package modelo.dao;

import java.util.List;

import modelo.javabean.Cliente;

public interface IClienteDao extends IGenericCRUD<Cliente, String>{
	
	/* 
	 * Métodos para manejar los clientes en específico 
	 * Nos apoyamos en el 'extends' para adoptar el CRUD genérico
	*/
	String exportar(String nombreFichero);
	List<Cliente> importar(String nombreFichero);
}
