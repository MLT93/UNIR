Algoritmo ejercicio4
	// Leer números de 1 a 250. Escribir  los que son múltiplos de 3 y 7.
	// Mostrar cuantos son multiplos de 3, de 7, de ambos y de ninguno al terminar.
	
	// Definir las variables
	Definir numero_actual, multiplos3y7, multiplos3, multiplos7, nomultiplos3ni7 como Entero;
	
	// Inicializar las variables a 0
	numero_actual = 0;
	multiplos3y7 = 0;
	multiplos3 = 0;
	multiplos7 = 0;
	nomultiplos3ni7 = 0;
	
	// Empleamos una estructura de tipo Para. La variable numero_actual 
	// comienza en 1 y en cada iteración va sumando 1 hasta llegar a 250.
	Para numero_actual<-1 Hasta 250 Con Paso 1 Hacer
		// Si se cumple esta condición, entonces el número no es múltiplo 
		// ni de 3 ni de 7.
		Si numero_actual % 3 <> 0 y numero_actual % 7 <> 0 Entonces
			nomultiplos3ni7 = nomultiplos3ni7 + 1;
		// En caso contrario, ha de ser múltiplo de alguno de ellos o 
		// de ambos
		SiNo
			// Es múltiplo de ambos
			Si numero_actual % 3 == 0 y numero_actual % 7 == 0 Entonces
				multiplos3y7 = multiplos3y7 + 1;
				Escribir numero_actual, " es múltiplo de 3 y de 7.";
			FinSi
			// Es múltiplo de 3 solamente
			Si numero_actual % 3 == 0 y numero_actual % 7 <> 0 Entonces
				multiplos3 = multiplos3 + 1;
			FinSi
			// Es múltiplo de 7 solamente
			Si numero_actual % 3 <> 0 y numero_actual % 7 == 0 Entonces
				multiplos7 = multiplos7 + 1;
			FinSi
		FinSi
	Fin Para
	
	// Mostramos los resultados obtenidos 
	Escribir multiplos3, " números son múltiplos de 3.";
	Escribir multiplos7, " números son múltiplos de 7.";
	Escribir multiplos3y7, " números son múltiplos de 3 y de 7.";
	Escribir nomultiplos3ni7, " números no son múltiplos ni de 3 ni de 7";
	
FinAlgoritmo
