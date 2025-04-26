package algoritmos;

public class Ejercicio09AclaracionString {

	public static void main(String[] args) {
		/* PRIMERA CONSIDERACION
		 * dos tipos de variables por su contenido en Java
		 *  - las que contienen el valor asignado : 8 tipos primitivos
		 *  - las variables de tipo calse: contienen una referencia al contenido del objeto
		 *  Una direccion de memoria
		 */
		
		/* SEGUNDA CONSIDERACION
		 * para crear un objeto de cualquier  clase   se hace asi:
		 * Scanner leer = new Scanner(System.in); // construir un objeto
		 * Persona persona = new Persona("tomas", "escudero");
		 * File fichero = new File();
		 * 
		 * String, para construir un objeto de la clase String, 
		 * generalmente, no se hace como los demás, una forma especial
		 * 
		 * String nombre = "eva"; // propia de String, y de alguna clase más (Clases envolventes)
		 * 
		 * 
		 */
		
		/* TERCERA CONSIDERACION
		 * los operadorEs de relacion:  ==  != < <= > >=, en java siempre compraran el contenido de las 
		 * variables:
		 *  -  variables de tipo primitivo, comparamos los valores reales
		 *  - variables de tipo clase, como su contenido es una diereccion de memoria, estamos
		 *  comparando si dos objetos apuntan al mismo String
		 *  
		 *  --- > usar un métod de objeto de String llamado equals.
		 */
		
		String cad1 = "andres" , cad2 = "andres";
		String cadena = null;
	//	String cadena1 = "";
		
		
		
		if (cad1.equals(cad2))
			System.out.println("son iguales");
		else
			System.out.println("son distintos");

	}

}
