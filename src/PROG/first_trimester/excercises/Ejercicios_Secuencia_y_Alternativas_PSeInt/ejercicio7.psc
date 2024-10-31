Algoritmo ejercicio7
	// Leer número y según sea 1, 2, 3 escribir "uno", "dos" o "tres".
	// Cualquier otro escribimos "Otro número".
	
	// Definimos las variables
	Definir num Como Entero;
	
	// Inicializamos las variables numéricas a 0
	num = 0;
	
	// Capturamos los datos de entradas para cada variable
	Escribir "Programa que lee el número que introduces (1-3) y lo devuelve en forma escrita.";
	Escribir "Introduce el número: ";
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
			Escribir "Otro número";
	Fin Segun
	Escribir "Programa finalizado";
	
FinAlgoritmo
