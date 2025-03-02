Algoritmo alternativa_multiple
	Definir opcion_menu Como Entero;
	opcion_menu = 0;
	Escribir "dame una opcion del 1 al 4";
	leer opcion_menu;
	
	Segun opcion_menu Hacer
		1,2:
			Escribir "suma";
		3,4:
			Escribir "resta";
		5,6:
			Escribir "multiplicar";
		7,8:
			Escribir "dividir";
		De Otro Modo:
			Escribir "opcion erronea";
	Fin Segun
	Escribir "Fin de programa";
FinAlgoritmo
