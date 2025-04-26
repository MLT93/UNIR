Algoritmo ifs_anidados_v2
	Definir numero1, numero2 Como Entero;
	numero1 =0; numero2=0;
	Leer numero1;
	Leer numero2;
	
	Si numero1 > numero2 Entonces
		Escribir "numero1 mayor";
	SiNo
		Si numero1 < numero2 Entonces
			Escribir "numero1 menor";
		SiNo
			Escribir "los dos iguales para hoy";
		Fin Si
	Fin Si
	Escribir "fin de programa";
FinAlgoritmo
