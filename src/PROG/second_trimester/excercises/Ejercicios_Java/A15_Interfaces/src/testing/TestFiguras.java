package testing;

import javabean.Cuadrado;
import javabean.Rectangulo;

public class TestFiguras {
	
	public static void main(String[] args) {
		Cuadrado cua1 = new Cuadrado(8);
		Rectangulo rec1 = new Rectangulo(6, 3);
		
		System.out.println(rec1.perimetro());
		
		String nombre = "tomas";
		String nombre2 = "Tomas";
		
		System.out.println(nombre.compareTo(nombre2));
		
		Integer numero1 = 7;
		Integer numero2 = 3;
		System.out.println(numero1.compareTo(numero2));
	}

}
