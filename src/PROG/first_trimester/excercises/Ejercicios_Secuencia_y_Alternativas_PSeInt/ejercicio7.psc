Algoritmo ejercicio7
	// Leer n�mero y seg�n sea 1, 2, 3 escribir "uno", "dos" o "tres".
	// Cualquier otro escribimos "Otro n�mero".
	
	// Definimos las variables
	Definir num Como Entero;
	
	// Inicializamos las variables num�ricas a 0
	num = 0;
	
	// Capturamos los datos de entradas para cada variable
	Escribir "Programa que lee el n�mero que introduces (1-3) y lo devuelve en forma escrita.";
	Escribir "Introduce el n�mero: ";
	Leer num;
	
	// Procesamos la entrada recibida y finalizamos
	Segun num Hacer
		1:
			Escribir "Uno";
		2:
			Escribir "Dos";
		3:
			Escribir "Tres";
		De Otro Modo:
			Escribir "Otro n�mero";
	Fin Segun
	Escribir "Programa finalizado";
	
FinAlgoritmo
