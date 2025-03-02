package algoritmos;

public class Ejercicio01ArrayUnidimensional {

	public static void main(String[] args) {
		int [] numeros = {2,3,4,6,7,89,123};
		numeros[6] = 45;
	
		for (int i=0; i < numeros.length; i++)
			System.out.println("en posicion : " + i + " esta el numero : " + numeros[i]);
		// necesita que tos los elemnetos del array
		// tengan contenido, que el array este lleno.
	
		for (int numero: numeros) {
			
			System.out.println("el numero contiene : " + numero);
		}
	}

}
