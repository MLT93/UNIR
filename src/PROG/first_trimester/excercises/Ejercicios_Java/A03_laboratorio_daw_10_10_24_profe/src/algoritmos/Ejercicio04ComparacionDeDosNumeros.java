package algoritmos;

public class Ejercicio04ComparacionDeDosNumeros {

	public static void main(String[] args) {
		/* leer dos numeros y decir cual es mayor
		 * menor o igual
		 */
		int num1=5, num2=3;
		
		if (num1 > num2)
			System.out.println("num1 mayor que num2");
		else 
			if (num1 < num2) {
				System.out.println("num1 es menor num2");
				System.out.println("otra sentencia");
			}
			else
				System.out.println("son iguales");
		
		
		if (num1 > num2) {
			System.out.println("mayor");
			
		} else 
			if (num1 < num2) {
				System.out.println("menor");
			} else {
				System.out.println("iguales");
			}
		
		
		
		System.out.println("FIN DE PROGRAMA");
	}

}
