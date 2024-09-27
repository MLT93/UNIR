Algoritmo ejercicio8
	// Leer dos n�meros y una palabra. Seg�n la palabra sea sumar, restar, dividir
	// multiplicar o resto, efectuar la operaci�n correspondiente.
	
	// Definimos las variables
	Definir numero1, numero2 Como Entero;
	Definir operacion Como Caracter;
	Definir resultado Como Real;
	
	// Inicializamos variables num�ricas a 0
	numero1 = 0;
	numero2 = 0;
	resultado = 0;
	
	// Capturamos los datos de entrada
	Escribir "Programa para realizar operaciones b�sicas con dos n�meros.";
	Escribir "Introduzca el primer n�mero: ";
	Leer numero1;
	Escribir "Introduzca el segundo n�mero: ";
	Leer numero2;
	Escribir "Introduzca la operaci�n a ejecutar (sumar, restar, multiplicar, dividir, resto):";
	Leer operacion;
	
	// Procesamos los datos capturados y finalizamos el programa
	Segun operacion Hacer	
		"sumar":
			resultado = numero1 + numero2;
			Escribir "El resultado es: ", resultado;
		"restar":
			resultado = numero1 - numero2;
			Escribir "El resultado es: ", resultado;
		"dividir": 
			resultado = numero1 / numero2;
			Escribir "El resultado es: ", resultado;
		"multiplicar":
			resultado = numero1 * numero2;
			Escribir "El resultado es: ", resultado;
		"resto":
			resultado = numero1 % numero2;
			Escribir "El resultado es: ", resultado;
		De Otro Modo:
			Escribir "Opci�n err�nea";
	FinSegun
	
FinAlgoritmo
