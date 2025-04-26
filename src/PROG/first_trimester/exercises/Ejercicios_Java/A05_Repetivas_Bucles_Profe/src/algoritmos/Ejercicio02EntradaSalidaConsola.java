package algoritmos;

import java.util.Scanner;

public class Ejercicio02EntradaSalidaConsola {

	public static void main(String[] args) {
		// Salida por consola en java
		int numero = 0; double numero2 = 0;;
	//	System.out.println("hola : " + 12);
		
		Scanner leer = new Scanner(System.in);
		System.out.println("Intoduce un numero : ");
		numero = leer.nextInt();
		
		System.out.println("Intoduce otro  numero : ");
		numero2 = leer.nextDouble();
		System.out.println(numero);
		System.out.println(numero2);
		
		
		
		leer.close();

	}

}
