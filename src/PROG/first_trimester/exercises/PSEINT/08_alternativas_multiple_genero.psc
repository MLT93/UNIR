Algoritmo sin_titulo
	Definir genero Como Caracter;
	Escribir "dime tu género H,h para hombre o M,m para mujer";
	Leer genero;
	
	Segun genero Hacer
		"H", "h":
			Escribir "eres un Hombre";
			
		"M", "m":
			Escribir "eres una Mujer";
		"Hombre":
			Escribir "literalmente eres un Hombre";
			
		De Otro Modo:
			Escribir "genero incorrecto";
	Fin Segun
	Escribir "FIN DE PROGRAMA";
FinAlgoritmo
