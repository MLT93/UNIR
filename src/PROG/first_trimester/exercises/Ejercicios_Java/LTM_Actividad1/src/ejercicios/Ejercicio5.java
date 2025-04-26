package ejercicios;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		/*
		 * Pedimos por pantalla un nombre y una contraseña: si el nombre coincide con
		 * “sara”, preguntamos por la contraseña y si coincide con “sarita”, escribimos
		 * el mensaje “usuario y contraseña correctas, bienvenido a la aplicación” Si el
		 * nombre NO es “sara” Escribimos usuario incorrecto” Si el nombre es correcto y
		 * la contraseña NO, Escribimos “contraseña incorrecta”
		 */
		
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Introduce el nombre de usuario:");
		String nombreUsuario = leer.next();
		
		if (nombreUsuario.equals("sara")) {
			System.out.println("Introduce la contraseña:");
			String password = leer.next();
			
			if (password.equals("sarita")) 
				System.out.println("Usuario y contraseña correctas, bienvenido a la aplicación");
			else
				System.out.println("Contraseña incorrecta");
		} else
			System.out.println("Usuario incorrecto");
		
		leer.close();
		
		System.out.println("Fin algoritmo");
	}

}
