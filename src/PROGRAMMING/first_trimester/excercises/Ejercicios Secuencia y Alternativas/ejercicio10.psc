Algoritmo ejercicio10
	// Pedimos por pantalla usuario y contraseña. Si el usuario y contraseña coinciden como
	// "sara" y "sarita", escribimos una cosa, y si no, escribimos otra.
	
	// Definimos las variables 
	Definir usuario, password Como Caracter;
	
	// Capturamos las variables de entrada.
	Escribir "Escriba su usuario y contraseña.";
	Escribir "Usuario: ";
	Leer usuario;

	// Procesamos la información y finalizamos la ejecución
	Si usuario == "sara" Entonces
		Escribir "Contraseña: ";
		Leer password;
		Si password == "sarita" Entonces
			Escribir "Usuario y contraseña correctos, bienvenid@ a la aplicación.";
		SiNo
			Escribir "Contraseña incorrecta";
		FinSi
	SiNo
		Escribir "Usuario incorrecto";
	FinSi
	
FinAlgoritmo
