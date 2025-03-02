package algoritmos;

public class Ejercicio04IfConString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// las distintas opciones de un algoritmo declarado coomo String
		
		
		String opcion = "editar"; // editar, ver, alta
		/*
		if (opcion == "editar")
			System.out.println("Han tecleado la opcion editar");
		else
			if (opcion == "ver")
				System.out.println("Han tecleado la opcion ver");
			else
				System.out.println("Han tecleado la opcion alta");
		*/
		
		if (opcion.equals("editar"))
			System.out.println("Han tecleado la opcion editar");
		else
			if (opcion.equals("ver"))
				System.out.println("Han tecleado la opcion ver");
			else
				System.out.println("Han tecleado la opcion alta");
		
		String opcion2 = new String("EdiTAr");
		
		if (opcion == opcion2)
			System.out.println("los dos tienen editar");
		else
			System.out.println("contienen cadenas de caracteres distintas.");
		
		if (opcion.equalsIgnoreCase(opcion2))
			System.out.println("LOS DOS contienen  IGUALES");
		else
			System.out.println("SON DISTINTOS");
		
		
		
		System.out.println("FIN DE PROGRAMA");

	}

}
