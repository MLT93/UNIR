Algoritmo ejercicio1
	// Leer un n�mero tras otro hasta encontrar 0. Mostrar cuantos 
	// n�meros han sido procesados, cual es la suma y cual es la media.
	
	// Definimos las variables 
	Definir numero_entrada, contador, suma Como Entero;
	Definir media Como Real;
	
	// Inicializamos las variables num�ricas a 0
	numero_entrada = 0;
	contador = 0;
	suma = 0;kw
	media = 0;
	
	// Pedimos la primera entrada
	Escribir "Programa para calcular la media y suma de un conjunto de n�meros.";
	Escribir "Introduce el primer n�mero:";
	Leer numero_entrada;
	
	// Comenzamos el bucle, utilizamos una estructura Mientras que
	// se ejecutar� siempre que el n�mero introducido sea distinto
	// a 0. En cada iteraci�n se pedir� el n�mero.
	Mientras numero_entrada <> 0 Hacer
		contador = contador + 1;
		suma = suma + numero_entrada;
		media = suma / contador;
		Escribir "Introduce otro n�mero:";
		Leer numero_entrada;
	Fin Mientras
	
	// Mostramos el resultado y finalizamos el programa
	Escribir "Se han introducido ", contador, " n�meros.";
	Escribir "La media es ", media, " y la suma es ", suma;
	
FinAlgoritmo
