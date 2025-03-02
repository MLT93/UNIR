package algoritmos;

public class Ejercicio02 {

	public static void main(String[] args) {
		// arrays llenos
		
	 	int [] numeros = {1,5,9,11,34,46};
	 	
	 			
		for (int numero: numeros) {
		
			if (numero%2 == 0)
				System.out.println(numero + " es par");
			else 
				System.out.println(numero + " es impar");
		
		}
		
		int [] pares = {2,4,6};
		
	  	numeros = pares;
		
		for (int numero: numeros) {
			
			if (numero%2 == 0)
				System.out.println(numero + " es par en segundo for");
			else 
				System.out.println(numero + " es impar en segundo for");
		
		}
		
		String [] nombres = {"carlos","eva","sara"};
		nombres[0] = "Sebastian";
		for (String nombre: nombres) {
			System.out.println(nombre.toUpperCase());
		}
		
		System.out.println(nombres[0]);
		

	}

}
