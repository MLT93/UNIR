package ejercicios;

public class Ejercicio3 {

	public static void main(String[] args) {
		/*
		 * Escribir todos los números del 100 al 0 de 7 en 7. Al final mostrar las
		 * siguientes Estadísticas. Cuantos números has escrito Cuanto suman los números
		 * escritos Cuantos de estos números son pares.
		 */

		int cont = 0;
		int suma = 0;
		int contPares = 0;

		for (int i = 100; i >= 0; i = i - 7) {
			System.out.println(i);

			cont++;
			suma += i;

			if (i % 2 == 0)
				contPares++;
		}

		System.out.println("Estadisticas");
		System.out.println("Némeros escritos: " + cont);
		System.out.println("Suma de los números escritos: " + suma);
		System.out.println("Números escritos pares: " + contPares);

		System.out.println("Fin algoritmo");
	}

}
