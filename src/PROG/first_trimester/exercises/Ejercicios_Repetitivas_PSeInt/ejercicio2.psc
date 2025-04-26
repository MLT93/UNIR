Algoritmo ejercicio2
	// Leer consecutivamente dos números cada vez, hasta que sean ambos -1.
	// Comparar si son =, > o < (el primero respecto al segundo). 
	// Informar cuantas veces se cumple cada condición.
	
	// Definir variables
	Definir numero1, numero2, iguales, primero_mayor, primero_menor Como Entero;
	
	// Inicializar las variables numéricas a 0
	numero1 = 0;
	numero2 = 0;
	iguales = 0;
	primero_mayor = 0;
	primero_menor = 0;
	
	// Mostramos un mensaje de inicio de programa
	Escribir "Programa para comparar conjuntos de números dos a dos.";
	
	// Utilizamos una estructura de tipo Repetir. Por cada iteración
	// capturamos los dos números y comprobamos si las condiciones
	// se cumplen.
	Repetir
		Escribir "Introduce el primer número:";
		Leer numero1;
		Escribir "Introduce el segundo número:";
		Leer numero2;
		Si numero1 == numero2 Entonces
			// Esta condición es un poco fea pero evita que se contabilice
			// la orden de "parada" como condición de igualdad entre los números.
			Si numero1 <> -1 y numero2 <> -1 Entonces
				iguales = iguales + 1;
			FinSi
		FinSi
		Si numero1 > numero2 Entonces
			primero_mayor = primero_mayor + 1;
		FinSi
		Si numero1 < numero2 Entonces
			primero_menor = primero_menor + 1;
		FinSi
	Mientras Que ( numero1 <> -1 ) y ( numero2 <> -1 )
	
	// Mostramos los resultados y finalizamos el programa
	Escribir "Los números han sido iguales ", iguales, " veces.";
	Escribir "El primero ha sido mayor ", primero_mayor, " veces.";
	Escribir "El primero ha sido menor ", primero_menor, " veces.";
	
FinAlgoritmo
