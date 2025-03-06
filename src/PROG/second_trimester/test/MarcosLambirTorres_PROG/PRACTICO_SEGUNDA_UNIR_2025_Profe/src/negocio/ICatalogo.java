package negocio;


import java.util.List;

import javabean.Producto;

// INTERFAZ QUE SE DEFINE EN EL UML CON LAS FUNCIONES ESPECÍFICAS REQUERIDAS
public interface ICatalogo {
	
	Producto buscarUno(long idProducto);
	List<Producto> buscarTodos();
	List<Producto> productosPorFamilia(int idFamilia);
	List<Producto> productosPorPrecioMayorQue(double precio);
	// Busca los productos cuya descripcion Larga coincida en cualquier parate del campo con la palabra
	// que le llega en el método; por ejemplo hombre 
	List<Producto> productosPorDescLarga(String descripcionLarga);
	List<Producto> productosPorProveedor(String cif);
	

	
}
