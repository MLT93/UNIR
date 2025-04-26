package algoritmos;

public class Ejercicio01 {

	public static void main(String[] args) {
		/*
		 * Leemos un numero entero que representa el radio de una circunferencia, y calculamos
		a. La circunferencia(2*PI*r)
		b. El área del circulo (PI * r2)
		 */
		
		double radio =14, circunferencia=0, areaCirculo = 0;
		
		circunferencia = 2 * Math.PI * radio;
		System.out.println("La circunferencia es : " + circunferencia + " cm");
		
		areaCirculo = Math.PI * Math.pow(radio, 2);
		System.out.println("El area es : " + areaCirculo);
		
	}

}
