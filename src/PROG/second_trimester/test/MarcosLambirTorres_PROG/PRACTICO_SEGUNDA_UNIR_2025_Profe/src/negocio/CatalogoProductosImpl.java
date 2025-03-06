package negocio;

import java.util.ArrayList;
import java.util.List;

import javabean.Familia;
import javabean.Producto;
import javabean.Proveedor;

// SIEMPRE DEBE IMPLEMENTAR LA INTERFAZ
// ESTA ES LA CLASE QUE DESARROLLA LOS MÉTODOS QUE SE USARÁN EN LA APLICACIÓN
public class CatalogoProductosImpl implements ICatalogo {
	
	private static ArrayList<Producto> lista;
	
	public void catalogoProductosImpl() {
		lista = new ArrayList<Producto>();
		cargarDatos();
	}

	private void cargarDatos() {
		
		Familia familia = new Familia(1,"Normal");
		Proveedor proveedor = new Proveedor("101", "Carlos", "Ventas", "b@b.es", "España");
		
		lista.add(new Producto(1, "Camiseta", "Camiseta negra hombre talla M", "Nike", "Negro", 40.00, familia , proveedor));
		lista.add(new Producto(2, "Pantalón", "Pantalón de Hombre negro", "Levi's", "Azul", 60.00,familia , proveedor));
		lista.add(new Producto(3, "Zapatillas", "Zapatillas deportivas de Mujer talla 37", "Adidas", "Blanco", 80.00,familia , proveedor));
		lista.add(new Producto(4, "Sudadera", "Sudadera con capucha de mujer", "Puma", "Gris", 55.00,familia , proveedor));
		lista.add(new Producto(5, "Chaqueta", "Chaqueta de cuero de mujer talla M", "Zara", "Negro", 120.00, familia , proveedor));

	}

	@Override
	public Producto buscarUno(long idProducto) {
		/*
		 * Por cada elemento en la lista Producto (FOR OF en JS porque devuelve el valor en vez
		 * que el index) que sea igual al ID buscado, devuélve el elemento
		 */
		for (Producto e : lista) {
			if (e.getIdProducto() == idProducto)
				return e;
		}
		
		return null;
	}
	
	public int insertOne(Producto objeto) {
		/*
		 * Si al buscar por el ID, el objeto posee un elemento (es != a `null`)
		 * devuelvo un 0 -> false. De lo contrario, añado el objeto y devuelvo un 1 -> true
		 */
		if (buscarUno(objeto.getIdProducto()) != null) {
			return 0;
		}
		lista.add(objeto);
		return 1;
	}
	
	public int updateOne(Producto objeto) {
		/*
		 * Si al buscar por el ID, el objeto es igual actualizamos el id vigente con el
		 * objeto entrante (el parámetro) y devuelvo un 1 -> true. De lo contrario,
		 * devuelvo un 0 -> false
		 */
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getIdProducto() == objeto.getIdProducto()) {
				lista.set(i, objeto);
				return 1;
			}
		}
		return 0;
	}
	
	public int deleteById(Integer atributoPk) {
		/*
		 * Se usa el método `removeIf` que borra sólo si existe el ID específico. Se devuelve un
		 * boolean dependiendo del éxito
		 */
		return lista.removeIf(e -> e.getIdProducto() == atributoPk) ? 1 : 0;
	}
	
	public int deleteObj(Producto objeto) {
		/*
		 * Se usa el método `removeIf` que borra sólo si existe el obj específico. Se devuelve un
		 * boolean dependiendo del éxito
		 */
		return lista.removeIf(e -> e.equals(objeto)) ? 1 : 0;
	}

	@Override
	public List<Producto> buscarTodos() {
		/*
		 * Se devuelve un nuevo Array a partir de la lista
		 */
		return new ArrayList<Producto>(lista);
	}

	@Override
	public List<Producto> productosPorFamilia(int idFamilia) {
		// aux para guardar array filtrado
		List<Producto> aux = new ArrayList<Producto>();
		
		for (Producto e : lista) {
			if (e.getFamilia().getIdFamilia() == idFamilia) {
				aux.add(e);
			}
		}
		return aux;
		
	}

	@Override
	public List<Producto> productosPorPrecioMayorQue(double precio) {
		// aux para guardar array filtrado
		List<Producto> aux = new ArrayList<Producto>();
		
		for (Producto e : lista) {
			if (e.getPrecio() > precio) {
				aux.add(e);
			}
		}
		return aux;
	}

	@Override
	public List<Producto> productosPorDescLarga(String descripcionLarga) {
		// aux para guardar array filtrado
		List<Producto> aux = new ArrayList<Producto>();
		
		for (Producto e : lista) {
			if (e.getDescripcionLarga().contains(descripcionLarga)) {
				aux.add(e);
			}
		}
		return aux;
	}

	@Override
	public List<Producto> productosPorProveedor(String cif) {
		// aux para guardar array filtrado
		List<Producto> aux = new ArrayList<Producto>();
		
		for (Producto e : lista) {
			if (e.getProveedor().getCif() == cif) {
				aux.add(e);
			}
		}
		return aux;
	}
}


