package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		/*
		 * Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente,
		 * Bien, Notable y sobresaliente. Si la nota introducida no está en el rango
		 * mostrar el mensaje “Nota errónea”.
		 */
		Scanner leer = new Scanner(System.in);

		System.out.println("Introduce la nota");
		double nota = leer.nextDouble();

		if (nota < 5 && nota >= 0)
			System.out.println("La nota es: insuficiente");
		else if (nota >= 5 && nota < 6)
			System.out.println("La nota es: suficiente");
		else if (nota >= 6 && nota < 8)
			System.out.println("La nota es: bien");
		else if (nota >= 8 && nota < 9)
			System.out.println("La nota es: notable");
		else if (nota >= 9 && nota <= 10)
			System.out.println("La nota es: sobresaliente");
		else
			System.out.println("Nota errónea");

		leer.close();
		
		System.out.println("Fin algoritmo");
	}

}
