Algoritmo ejercicio1
	// Leer un número tras otro hasta encontrar 0. Mostrar cuantos 
	// números han sido procesados, cual es la suma y cual es la media.
	
	// Definimos las variables 
	Definir numero_entrada, contador, suma Como Entero;
	Definir media Como Real;
	
	// Inicializamos las variables numéricas a 0
	numero_entrada = 0;
	contador = 0;
	suma = 0;
	media = 0;
	
	// Pedimos la primera entrada
	Escribir "Programa para calcular la media y suma de un conjunto de números.";
	Escribir "Introduce el primer número:";
	Leer numero_entrada;
	
	// Comenzamos el bucle, utilizamos una estructura Mientras que
	// se ejecutará siempre que el número introducido sea distinto
	// a 0. En cada iteración se pedirá el número.
	Mientras numero_entrada <> 0 Hacer
		contador = contador + 1;
		suma = suma + numero_entrada;
		media = suma / contador;
		Escribir "Introduce otro número:";
		Leer numero_entrada;
	Fin Mientras
	
	// Mostramos el resultado y finalizamos el programa
	Escribir "Se han introducido ", contador, " números.";
	Escribir "La media es ", media, " y la suma es ", suma;
	
FinAlgoritmo