Algoritmo ejercicio6
	// Leemos un n�mero y Escribimos si el n�mero es par o impar
	
	// Definimos las variables
	Definir num, resto Como Entero;
	
	// Inicializamos las variables num�ricas a 0
	num = 0;
	resto = 0;
	
	// Capturamos el n�mero
	Escribir "Programa para determinar si un n�mero es par o impar.";
	Escribir "Introduzca el n�mero: ";
	Leer num;
	
	// Procesamos el resto
	resto = num % 2;
	
	// Empleamos una alternativa multiple para comprobar si el resto es 1 o 0
	Si resto == 1 Entonces
		Escribir "El n�mero es impar.";
	SiNo
		Escribir "El n�mero es par.";
	FinSi
	
	// Notificamos que el programa ha terminado
	Escribir "Programa finalizado";
	
FinAlgoritmo
