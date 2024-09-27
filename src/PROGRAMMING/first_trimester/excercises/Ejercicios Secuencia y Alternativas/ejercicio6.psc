Algoritmo ejercicio6
	// Leemos un número y Escribimos si el número es par o impar
	
	// Definimos las variables
	Definir num, resto Como Entero;
	
	// Inicializamos las variables numéricas a 0
	num = 0;
	resto = 0;
	
	// Capturamos el número
	Escribir "Programa para determinar si un número es par o impar.";
	Escribir "Introduzca el número: ";
	Leer num;
	
	// Procesamos el resto
	resto = num % 2;
	
	// Empleamos una alternativa multiple para comprobar si el resto es 1 o 0
	Si resto == 1 Entonces
		Escribir "El número es impar.";
	SiNo
		Escribir "El número es par.";
	FinSi
	
	// Notificamos que el programa ha terminado
	Escribir "Programa finalizado";
	
FinAlgoritmo
