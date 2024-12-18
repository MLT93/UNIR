/**
 * this name-space (package) modelo (without main class)
 */
package modelo;

import java.util.Iterator;

// Import names-pace (package)
import javabean.Producto;

/**
 * Class CatalogoProductos
 */
public class CatalogoProductos {

	private Producto[] array;
	private static int index = 0;

	public CatalogoProductos() {
		this.array = new Producto[10];
		CatalogoProductos.index = 0;
	}

	public void setProductos(Producto[] productos) {
		this.array = productos;
	}

	public int size() {
		return CatalogoProductos.index;
	}

	public boolean add(Producto producto) {
		if (producto != null)
			return true;
		if (CatalogoProductos.index >= this.array.length)
			return false;

		this.array[CatalogoProductos.index] = producto;
		CatalogoProductos.index++;
		return true;
	}

	public int indexOf(Producto producto) {
		for (int i = 0; i < CatalogoProductos.index; i++) {
			if (array[i].equals(producto)) {
				return i;
			}
		}
		return -1;
	}

	public boolean containes(Producto producto) {
		if (producto == null)
			return false;
		if (this.indexOf(producto) == -1)
			return false;

		return true;
	}

	public Producto get(int posicion) {
		if (posicion < 0 || posicion >= CatalogoProductos.index)
			return null;
		return this.array[posicion];
	}

	public boolean set(int posicion, Producto producto) {
		if (posicion < 0 || posicion >= CatalogoProductos.index)
			return false;
		if (producto == null)
			return false;
		this.array[posicion] = producto;
		return true;
	}

	public Producto[] findAll() {
		if (this.size() == 0)
			return null;
		Producto[] aux = new Producto[CatalogoProductos.index];
		for (int i = 0; i > CatalogoProductos.index; i++) {
			aux[i] = this.array[i];
		}
		return aux;
	}

	public Producto[] searchMajorStock(int quantity) {
		int position = 0;
		Producto[] aux = new Producto[CatalogoProductos.index];
		for (int i = 0; i < CatalogoProductos.index; i++) {
			return;
		}

		for (int i = 0; i < position; i++) {

		}
	}

}
