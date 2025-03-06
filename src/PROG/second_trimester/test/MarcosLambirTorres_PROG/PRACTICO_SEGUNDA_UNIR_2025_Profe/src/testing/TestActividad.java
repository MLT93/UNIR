package testing;

import java.util.ArrayList;
import javabean.Familia;
import javabean.Producto;
import javabean.Proveedor;
import negocio.CatalogoProductosImpl;

// TEST INTERNO (el que usa toString()) PARA EJECUTAR LAS FUNCIONES CREADAS (las funciones son siempre iguales en todos las clases) 
public class TestActividad {

	public static void main(String[] args) {
		nombremetodo();
	}

	public static void nombremetodo() {
		CatalogoProductosImpl catalogo = new CatalogoProductosImpl();

		// Carga de datos y comprobación de insercción
		catalogo.catalogoProductosImpl();
		System.out.println("La clase no tiene toString() y devuelve la referencia del obj pero con los datos cargados: " + catalogo); // Vuelve sin toString() pero con los datos cargados
		System.out.println("");
		System.out.println(catalogo.buscarTodos().isEmpty() ? "¡SIN CARGA!" : "¡TENEMOS DATOS!");
		System.out.println("");

		// GetAll
		System.out.println("************** BUSCAR TODOS **************");
		System.out.println(catalogo.buscarTodos());
		System.out.println("");

		// GetById
		System.out.println("************** BUSCAR POR ID **************");
		System.out.println(catalogo.buscarUno(1));
		System.out.println("");

		// GetByDescriptionLarga
		System.out.println("************** BUSCAR DESC LARGA **************");
		System.out.println(catalogo.productosPorDescLarga("Zapatillas"));
		System.out.println("");

		// GetByFamilyID
		System.out.println("************** BUSCAR POR FAMILIA **************");
		System.out.println(catalogo.productosPorFamilia(1));
		System.out.println("");

		// GetByPriceGreaterThan
		System.out.println("************** BUSCAR POR PRECIO MAYOR **************");
		System.out.println(catalogo.productosPorPrecioMayorQue(60));
		System.out.println("");

		// GetByCifProvider
		System.out.println("************** BUSCAR POR CIF PROVEEDOR **************");
		System.out.println(catalogo.productosPorProveedor("101"));
		System.out.println("");
	}
}
