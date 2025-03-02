package algoritmos;

public class Ejercicio06AlternativaMultipleSwitch {

	public static void main(String[] args) {
		/*
		 * cuando una variable, de tipo entero, char o String
		 * tiene una serie de valores especificos (==) con
		 * distinto tratamiento usaremos la alternativa Segun -> switch
		 */
		
		int diaDeLaSemana = 6;
		
		switch(diaDeLaSemana){
		case 1:
			System.out.println("Es lunes");
			break;
		case 2:
			System.out.println("Es martes");
			break;
		case 3:
			System.out.println("Es miercoles");
			break;
		case 4:
			System.out.println("Es jueves");
			break;
		case 5:
			System.out.println("Es viernes");
			break;
		default:
			System.out.println("Es fin de semana");
			
		}
		
		System.out.println("FIN DE PROGRAMA");

	}

}
