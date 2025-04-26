package ejercicios;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		/*
		 * Leer números hasta que se introduzca un cero. Para cada uno indicar si es par
		 * o impar. Al final mostrar las siguientes Estadísticas: cuantos son pares e
		 * impares cuanto suman los pares y cuanto los impares.
		 */

		Scanner leer = new Scanner(System.in);

		int contPares = 0;
		int contImpares = 0;
		int sumaPares = 0;
		int sumaImpares = 0;

		System.out.println("Introduce un número para ver si es par o impar");
		System.out.println("O introduce 0 para salir.");
		int numero = leer.nextInt();

		while (numero != 0) {
			if (numero % 2 == 0) {
				System.out.println("El numero " + numero + " es par.");
				sumaPares += numero;
				contPares++;
			} else {
				System.out.println("El numero " + numero + " es impar.");
				sumaImpares += numero;
				contImpares++;
			}
			
			System.out.println("Introduce un número para ver si es par o impar");
			System.out.println("O introduce 0 para salir.");
			numero = leer.nextInt();
		}
		
		leer.close();
		
		System.out.println("Estadisticas");
		System.out.println("Némeros pares: " + contPares);
		System.out.println("Suma de los números pares: " + sumaPares);
		System.out.println("Números impares: " + contImpares);
		System.out.println("Suma de los números impares: " + sumaImpares);

		System.out.println("Fin algoritmo");
	}
}
