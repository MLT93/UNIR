package algoritmos;

public class Ejercicio01BuclesEnGeneral {

	public static void main(String[] args) {
		/*
		 * en Java hay 3 tipods de Bucles, todos mientras que:
		 * dividos en dos secciones
		 * 1.- NOOOOO se el numero de veces que tengo que iterar : while y do-while
		 * - Bucle de 0 a n: primero pregunta y si no se cumple se va
		 * 	pio de bucle	
		 * while (condicion){
		 * 	tratamiento de 1
		 * }
		 * final bucle
		 * 
		 * bucle de 1 a n: primero entra y al final pregunta
		 * 	do{
		 * 	i1;
		 *  i2;
		 * 
		 * 
		 * } while(condicion);
		 * 
		 *  conozco las veces que lo voy a iterar: minimo / maximo
		 * for : 2 maneras distintas
		 *  - for original, que itera numeros enteros
		 *  - for para arrays y colecciones
		 */
		int numero = 1;
		while (numero <= 10) {
			System.out.println("el numero es : " + numero);
			numero++;
		}
		numero=1;
		do {
			System.out.println("el numero con do while es : " + numero);
			numero++;
			
		}while(numero <=10);
		
		for (int i=1 ; i<= 10; i++) {
			System.out.println("el numero con for es : " + i);
		}
		
		for (int i=4 ; i >= 1; i--) {
			System.out.println("el numero con for es : " + i);
		}
		
	//	System.out.println(i);
		
		System.out.println("FIN DE PROGRAMA");
		

	}

}
