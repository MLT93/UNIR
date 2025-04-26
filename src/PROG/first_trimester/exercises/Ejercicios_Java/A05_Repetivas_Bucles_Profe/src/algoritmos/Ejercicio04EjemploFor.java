package algoritmos;

public class Ejercicio04EjemploFor {

	public static void main(String[] args) {
		/*
		 * Procesar números del 100 a 1. Escribir cada número leído. 
		 * Al final del proceso decir cuántos números
			he leído, cuantos son múltiplos de dos y cuantos son múltiplos de 3.
		 */
		int cont =0, contMul2=0, contMul3=0;
		
		for (int i= 100; i>= 1; i--) {
			System.out.println(i);
			if (i%2 == 0)
				contMul2++;
		//	else
			if (i%3 == 0)
				contMul3++;
			
			cont++;
		}
		
		System.out.println("ESTADISTICAS");
		System.out.println("numeros procesados : " + cont);
		System.out.println("multiplos de dos : " + contMul2);
		System.out.println("multiplos de tres : " + contMul3);
		

	}

}
