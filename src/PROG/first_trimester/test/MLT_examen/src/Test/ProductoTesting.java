/**
 * Package Test (with main class)
 */
package Test;

/**
 * Import class
 */
import Javabean.Producto;

/**
 * Class ProductoTesting
 */
public class ProductoTesting {

	/**
	 * Class Main
	 */
	public static void main(String[] args) {
		
		// Instance of Producto
		Producto prod = new Producto();
		
		// Methods of prod
        prod.setLongBarcode(1236544898L);
        prod.setStrDescription("Camiseta T-Shirt");
        prod.setDblePrice(45.00);
        prod.setIntStock(50);
        prod.setStrSize("M");
        prod.setStrColor("Rojo");
        System.out.println("Prod + IVA: " + prod.priceWithIVA(21));
        prod.increaseStock(109);
        System.out.println("Nuevo stock de prod: " + prod.getIntStock());
        prod.decreaseStock(9);
        System.out.println("Stock de prod decrecido: " + prod.getIntStock());
        System.out.println("**************************************************");
        
        // Instance of Producto 2
        Producto prod2 = new Producto(2255882255L, "Polo Gray Simple", 50.00, 100, "XXL", "Gray");
        System.out.println("Prod 2 + IVA: " + prod2.priceWithIVA(21));
        prod2.increaseStock(50);
        System.out.println("Nuevo stock de prod 2: " + prod2.getIntStock());
        prod2.decreaseStock(30);
        System.out.println("Stock de prod 2 decrecido: " + prod2.getIntStock());
        System.out.println("**************************************************");
        
        // Instance of Producto 3
        Producto prod3 = new Producto(3255846255L, "Sudadera Estampada", 70.00, 140, "XS", "Violet");
        System.out.println("Prod 2 + IVA: " + prod3.priceWithIVA(21));
        prod3.increaseStock(10);
        System.out.println("Nuevo stock de prod 3: " + prod3.getIntStock());
        prod3.decreaseStock(40);
        System.out.println("Stock de prod 3 decrecido: " + prod3.getIntStock());
        System.out.println("**************************************************");
        
        // Testing
        String[] arrProdSizes = {"XS", "S", "M", "L", "XL", "XXL", "XXXL"};

        for (int i = 0; i < arrProdSizes.length; i++) {
            prod.setStrSize(arrProdSizes[i]);
            double appliedPrice = prod.appliedPrice();
            System.out.println("Size: " + arrProdSizes[i] + " El precio es: " + appliedPrice);
        }
        
        System.out.println("**************************************************");

        for (String element : arrProdSizes) {
            prod2.setStrSize(element);
            double appliedPrice = prod2.appliedPrice();
            System.out.println("Size: " + element + " El precio es: " + appliedPrice);
        }
	}

}
