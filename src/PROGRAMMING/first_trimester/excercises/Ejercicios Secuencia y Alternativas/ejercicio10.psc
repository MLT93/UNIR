Algoritmo ejercicio10
	// Pedimos por pantalla usuario y contrase�a. Si el usuario y contrase�a coinciden como
	// "sara" y "sarita", escribimos una cosa, y si no, escribimos otra.
	
	// Definimos las variables 
	Definir usuario, password Como Caracter;
	
	// Capturamos las variables de entrada.
	Escribir "Escriba su usuario y contrase�a.";
	Escribir "Usuario: ";
	Leer usuario;

	// Procesamos la informaci�n y finalizamos la ejecuci�n
	Si usuario == "sara" Entonces
		Escribir "Contrase�a: ";
		Leer password;
		Si password == "sarita" Entonces
			Escribir "Usuario y contrase�a correctos, bienvenid@ a la aplicaci�n.";
		SiNo
			Escribir "Contrase�a incorrecta";
		FinSi
	SiNo
		Escribir "Usuario incorrecto";
	FinSi
	
FinAlgoritmo
