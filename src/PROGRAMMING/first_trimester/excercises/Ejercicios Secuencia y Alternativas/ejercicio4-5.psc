Algoritmo ejercicio4
	// Leer por consola las letras "h", "H", "m", y "M" y escribir el literal correspondiente (hombre o mujer)
	// NOTA: Sólo se escribe el literal deseado, pues no se especifica que se desee mostrar el resultado por consola.
	
	// Definimos las variables necesarias
	Definir sexo, resultado Como Caracter;
	
	// Capturamos el sexo por consola
	Escribir "Escribe h o H si es hombre, m o M si es mujer:";
	Leer sexo;
	
	// Procesamos si es hombre o mujer mediante dos alternativas dobles anidadas.
	Si (sexo == "h" || sexo == "H") || (sexo == "m" || sexo ="M") Entonces
		Si sexo == "h" || sexo == "H" Entonces
			resultado = "hombre";
		SiNo
			resultado = "mujer";
		Fin Si
	SiNo
		Escribir "¡Error en el sexo introducido!";
	Fin Si
	
	// Finalizamos el programa
	Escribir "Programa finalizado.";
	
FinAlgoritmo