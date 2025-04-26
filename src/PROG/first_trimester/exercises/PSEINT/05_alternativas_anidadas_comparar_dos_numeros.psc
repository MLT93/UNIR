Algoritmo alternativas_anidadas
	Definir numero1, numero2 Como Entero;
	numero1 =0; numero2=0;
	Leer numero1;
	Leer numero2;
	
	Si numero1 > numero2 Entonces
		Escribir "numero1 es mayor que el segundo numero";
		
	SiNo
		Si numero1 < numero2 Entonces
			Escribir "numero1 es menor que el segundo numero";
		SiNo
			Escribir "Los dos son iguales";
		FinSi
		
	FinSi
	Escribir "FIN DE PROGRAMA";
	
	
FinAlgoritmo
