
/**
 * Package for testing (with class main)
 */
package testing;

/**
 * Import class Fiesta
 */
import javabean.Fiesta;

/**
 * Execution of Test
 */
public class Principal {

	public static void main(String[] args) {
		
        // Instance of Fiesta
        Fiesta fiesta1 = new Fiesta();

        // Use methods
        fiesta1.invitar(10);  // Invitar a 10 personas
        fiesta1.bebidasConsumidas(20);  // Añadir 20 bebidas
        fiesta1.bocadillosComidos(15);  // Añadir 15 bocadillos

        // Mostrar detalles de la fiesta
        fiesta1.show();

	}

}
