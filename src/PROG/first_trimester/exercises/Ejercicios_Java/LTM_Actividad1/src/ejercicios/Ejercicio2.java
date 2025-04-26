package ejercicios;

public class Ejercicio2 {

	public static void main(String[] args) {
		/*
		 * Diseñar un programa que muestre el producto y la suma de los 10 primeros
		 * números impares.
		 */
		
		int contImpares = 0;
		int producto = 1;
		int suma = 0;
		int acumulador = 0;
		
		while (contImpares < 10) {
			
			if (acumulador % 2 != 0) {
				producto = producto * acumulador;
				suma = suma + acumulador;
				contImpares++;
			}
			
			acumulador++;
		}
		
		System.out.println("El producto de los 10 primeros número impares es: " + producto);
		System.out.println("El suma de los 10 primeros número impares es: " + suma);
		
		System.out.println("Fin algoritmo");
		
	}

}
