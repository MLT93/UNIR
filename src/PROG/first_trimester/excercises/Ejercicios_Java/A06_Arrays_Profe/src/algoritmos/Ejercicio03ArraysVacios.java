package algoritmos;

public class Ejercicio03ArraysVacios {

	public static void main(String[] args) {
		System.out.println(args.length);
		//entreros -> 0
		//double -> 0.0
		//char -> \0
		//boolean -> false
		//Clase -> null
		int [] enteros = new int[4];
		double [] reales = new double[4];
		char [] letras = new char[4];
		boolean [] logicos = new boolean[4];
		String [] palabras = new String[4];
		System.out.println("ENTEROS");
		for (int ele: enteros) {
			System.out.println(ele);
		}
		System.out.println("DOUBLE");
		for (double ele: reales) {
			System.out.println(ele);
		}
		System.out.println("CHAR");
		for (char ele: letras) {
			System.out.println(ele);
		}
		System.out.println("BOOLEANOS");
		for (boolean ele: logicos) {
			System.out.println(ele);
		}
		System.out.println("STRING");
		for (String ele: palabras) {
			System.out.println(ele.toUpperCase());
		}
		
		
		
		
		palabras[0].toUpperCase();
		
		

	}

}
