package algoritmos;

public class Ejercicio07SwitchSinBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * que meses son de 30 dias , que meses con de 31 y el 28/29
		 */
		
		int mes = 22;
		
		switch (mes) {
		case 1:
		case 3:
		//	System.out.println("empieza la primavera");
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("es de 31 dias");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("es de 30");
			break;
		case 2:
			System.out.println("de 28/29");
			break;
		default:
			System.out.println("mes incorrecto");
		}
		

	}

}
