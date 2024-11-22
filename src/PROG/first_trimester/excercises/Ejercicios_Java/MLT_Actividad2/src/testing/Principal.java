
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
        Fiesta fiesta2 = new Fiesta("Cumpleaños", "Calle Principal 123", 50, 100, 30, "2024-01-15", "20:00");

        // Metodos para fiesta1
        fiesta1.tipoFiesta("Boda");
        fiesta1.dateTime("22/11/2024", 18.5); // Establecer fecha y hora
        fiesta1.direccionFiesta("Avenida Siempre Viva, 742");
        fiesta1.invitar(100);  // Invitar a 10 personas
        fiesta1.cancelarInvitacion(2) // Cancelaron 2 personas
        fiesta1.bebidasConsumidas(200);  // Añadir 200 bebidas
        fiesta1.bocadillosComidos(300);  // Añadir 300 bocadillos
        fiesta1.precioFiesta(); // Precio total de la fiesta
        
        // Metodos para fiesta2
        fiesta2.precioFiesta(); // Precio total de la fiesta
        fiesta2.cancelarInvitacion(10) // Cancelaron 10 personas
        
        // Mostrar detalles de la fiesta
        fiesta1.show();
        fiesta2.show()

	}

}
