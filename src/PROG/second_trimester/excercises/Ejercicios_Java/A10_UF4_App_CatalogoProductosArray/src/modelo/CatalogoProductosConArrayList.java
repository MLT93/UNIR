package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import javabean.Producto;

public class CatalogoProductoConArrayList<E>List {
	
	private ArrayList<Producto> arr;
	
	public CatalogoProductoConArrayList() {
		arr = new ArrayList<Producto>();
	}
	
	public boolean addProducto(Producto producto) {
		return arr.add(producto);
	}
	
	public boolean modificarProducto(Producto producto) {
		int posicion = arr.indexOf(producto);
		
		if (posicion == -1) {
			return false;
		arr.set(posicion, producto);
		return true;
		}
	}
	
	public boolean eliminarProducto(Producto producto) {
		return arr.remove(producto);
	}
	
	public Producto buscarUno(int codigoBarras) {
		for (Producto element: arr) {
			if(element.getCodigoDeBarras()==codigoBarras)
				return element;
		}
	}
	
	public ArrayList<Producto> searchMajorStock(int cantidad){
		ArrayList<Producto> aux = new ArrayList<producto>();
		fo
	}
	
	public ArrayList<Producto> searchAll(){
		return arr;
	}
}
