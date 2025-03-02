package algoritmos;

public class Ejercicio03IfConChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// en vez de leer que no sabemos de momento
		//le asignamos un valor a genero y probamos con el
		// una variable en un momento determinado solo puede tener un valor
		// and &&   or ||
		char genero = 'H';
		
		if (genero == 'H' || genero == 'h')
			System.out.println("eres un hombre");
			
		else
			if (genero == 'M' ||  genero == 'm')
				System.out.println("Eres una mujer");
		
			else
				System.out.println("Genero Incorrecto");
				
		
		

	}

}
