Funcion literal <- nombreCompleto ( nombre, apellido )
	Definir literal Como Caracter;
	literal = Mayusculas(nombre) + " " + Mayusculas(apellido);
	
Fin Funcion


Funcion   EscribirLiteral ( genero )
	Segun genero Hacer
		"H", "h":
			Escribir "Eres un Hombre";
		"M", "m":
			Escribir "Eres una Mujer";
		De Otro Modo:
			Escribir "Genero Incorrecto";
	Fin Segun
Fin Funcion



Funcion literal <- literalGenero ( genero )
	// genero = "i"
	Definir literal Como Caracter;
	
	Segun genero Hacer
		"H", "h":
			literal = "Hombre";
		"M", "m":
			literal="Mujer";
		De Otro Modo:
			literal = "Incorrecto";
	Fin Segun
	
Fin Funcion

Algoritmo sin_titulo
//	Escribir literalGenero("H");
//	Escribir literalGenero("M");
//	Escribir literalGenero("h");
//	Escribir literalGenero("m");
//	Escribir literalGenero("i");
//	Escribir literalGenero("J");
	Definir generos Como Caracter;
	Definir i como entero;
	dimension generos[6];
	generos[0] = "H";
	generos[1] = "h";
	generos[2] = "M";
	generos[3] = "m";
	generos[4] = "J";
	generos[5] = "k";
	
	Para i=0 Hasta 5 Con Paso 1 Hacer
		Escribir literalGenero(generos[i]);
	Fin Para
	
	EscribirLiteral("H");
	
	Escribir "mi nombre completo es : " , nombreCompleto("tomas","saavedra");
	
FinAlgoritmo
