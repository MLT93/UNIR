package algoritmos;

public class Ejercicio05StringIgualYComparar {

	public static void main(String[] args) {
		String cad1 = "Tomas", cad2 = "tomas";
		
		if (cad1.equals(cad2))
			System.out.println("iguales");
		else
			System.out.println("diferentes");
		
		if (cad1.equalsIgnoreCase(cad2))
			System.out.println("iguales");
		else
			System.out.println("diferentes");
		
		System.out.println(cad1.compareTo(cad2));
		System.out.println(cad1.compareToIgnoreCase(cad2));
		
		
		

	}

}
