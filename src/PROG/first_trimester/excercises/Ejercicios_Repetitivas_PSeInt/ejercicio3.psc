Algoritmo ejercicio3
	// Leer n�meros de 1 al 100. Escribir cada n�mero. Al finalizar
	// leer el total, cuantos son m�ltiplos de dos y cuantos de 3.
	
	// Definir las variables
	Definir numero_actual, numeros_leidos, multiplos2, multiplos3 como Entero;
	
	// Inicializar las variables a 0
	numero_actual = 0;
	multiplos2 = 0;
	multiplos3 = 0;
	numeros_leidos = 0;
	
	// Procesamos el bucle. La variable numero_actual comienza en 100
	// y en cada iteraci�n va tomando los valores desde 100 a 1.
	Para numero_actual<-100 Hasta 1 Con Paso -1 Hacer
		numeros_leidos = numeros_leidos + 1;
		// Si el resto del n�mero dividido entre dos es 0, es par.
		Si numero_actual % 2 == 0 Entonces
			multiplos2 = multiplos2 + 1;
		FinSi
		// Si el resto del n�mero dividido entre tres, es m�ltiplo de 3.
		Si numero_actual % 3 == 0 Entonces
			multiplos3 = multiplos3 + 1;
		FinSi
	Fin Para
	
	// Mostramos los resultados obtenidos
	Escribir "Hemos leido ", numeros_leidos, " n�meros en total.";
	Escribir multiplos2, " son m�ltiplos de 2.";
	Escribir multiplos3, " son m�ltiplos de 3.";
	
FinAlgoritmo
