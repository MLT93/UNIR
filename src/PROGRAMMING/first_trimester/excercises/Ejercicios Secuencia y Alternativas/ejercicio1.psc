Algoritmo ejercicio1
	// Leer por consola dos n�meros enteros y mostrar suma, resta, producto, division y resto
	
	// Definimos las variables
	Definir entero1, entero2, suma, resta, producto, resto Como Entero;
	Definir division Como Real;
	
	// Inicializamos las variables, en este caso todas num�ricas a 0
	entero1 = 0;
	entero2 = 0;
	suma = 0;
	resta = 0;
	producto = 0;
	resto = 0;
	division = 0;
	
	// Capturamos los dos n�meros enteros via teclado/consola
	Escribir "Programa para calcular la suma, resta, producto, divisi�n y resto de dos enteros.";
	Escribir "Introduce el primer n�mero entero:";
	Leer entero1;
	Escribir "Introduce el segundo n�mero entero:";
	Leer entero2;
	
	// Hacemos todos los cálculos
	suma = entero1 + entero2;
	resta = entero1 - entero2;
	producto = entero1 * entero2;
	division = entero1 / entero2;
	resto = entero1 % entero2;
	
	// Mostramos los resultados en consola y finalizamos el programa
	Escribir "Los resultados han sido calculados.";
	Escribir "La suma es: ", suma;
	Escribir "La resta es: ", resta;
	Escribir "La producto es: ", producto;
	Escribir "La division es: ", division;
	Escribir "El resto es: ", resto;
	Escribir "Programa terminado.";
	
FinAlgoritmo
