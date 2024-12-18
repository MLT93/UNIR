package testing;

// Imports
import java.util.ArrayList;
import javabean.Producto;

public class TestCatalogoProductosConArrayList {

	public static void main(String[] args) {
		ArrayList<Producto> arr = new ArrayList<>();
		
		arr.add(new Producto(1001, "Camisa", 123, 30, "XS", "Blanco"));
		arr.add(new Producto(1002, "T-Shirt", 123, 30, "L", "Violeta"));
		arr.add(new Producto(1003, "Pantalón", 123, 30, "M", "Gris"));
		arr.add(new Producto(1004, "Falda", 123, 30, "XS", "Amarillo"));
		arr.add(new Producto(1005, "Gorra", 123, 30, "XL", "Kacki"));
		arr.add(new Producto(1006, "Sudadera", 123, 30, "XXL", "Azul"));
		
		System.out.println(arr.size());
	}

}
