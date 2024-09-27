Algoritmo ejercicio8
	// Leer dos números y una palabra. Según la palabra sea sumar, restar, dividir
	// multiplicar o resto, efectuar la operación correspondiente.
	
	// Definimos las variables
	Definir numero1, numero2 Como Entero;
	Definir operacion Como Caracter;
	Definir resultado Como Real;
	
	// Inicializamos variables numéricas a 0
	numero1 = 0;
	numero2 = 0;
	resultado = 0;
	
	// Capturamos los datos de entrada
	Escribir "Programa para realizar operaciones básicas con dos números.";
	Escribir "Introduzca el primer número: ";
	Leer numero1;
	Escribir "Introduzca el segundo número: ";
	Leer numero2;
	Escribir "Introduzca la operación a ejecutar (sumar, restar, multiplicar, dividir, resto):";
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
			Escribir "Opción errónea";
	FinSegun
	
FinAlgoritmo
