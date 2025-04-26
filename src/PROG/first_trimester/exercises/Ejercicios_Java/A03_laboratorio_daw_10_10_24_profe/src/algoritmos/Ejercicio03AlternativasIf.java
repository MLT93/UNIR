package algoritmos;

public class Ejercicio03AlternativasIf {

	public static void main(String[] args) {
		int edad = 12;
		// Solo if una sola sentencia
		if (edad >= 18)
			System.out.println("mayor de edad");
		
		// Sol if mas de una sentencia
		if (edad >= 18) {
			System.out.println("MAYOR de edad");
			System.out.println("y eres adulto");
		}
		
		//rama if y rama else solo una sentencia
		
		if (edad >= 18)
			System.out.println("ERES MUU MAYOR");
		else
			System.out.println("ERES MUU PEQUEÑO");
		
		//rama if y rama else con mas de una sentencia
		
				if (edad >= 18) {
					System.out.println("ERES MUU MAYOR");
					System.out.println("Y ERES SENIOR");
				}
				else {
					System.out.println("ERES MUU PEQUEÑO");
					System.out.println("Y CHIQUITIN");
				}
				
				
				if (edad>= 18) {
					System.out.println("porras");
					edad++;
				}else {
					System.out.println("rama else");
					edad *= 7;
				}
		
		System.out.println("FIN DE PROGRAMA");
		

	}

}
