Algoritmo sin_titulo
	//Leer n�meros del 100 a 1. Escribir cada n�mero le�do. Al final del proceso decir cu�ntos 
	//n�meros he le�do, cuantos son m�ltiplos de dos y cuantos son m�ltiplos de 3.
	Definir i, cont_numeros, mul_2 , mul_3 Como Entero;
	i=0; cont_numeros=0; mul_2 =0; mul_3 =0;
	
	Para i=100 Hasta 1 Con Paso -1 Hacer
		Escribir i;
		cont_numeros = cont_numeros +1;
		
		Si i % 2 = 0 Entonces
			mul_2 = mul_2 +1;
		Fin Si
		Si i % 3 = 0 Entonces
			mul_3 = mul_3 +1;
		Fin Si
		
	Fin Para
	
	//Estadisticas
	Escribir "numeros leidos : ", cont_numeros;
	Escribir "multiplos de 2 : ", mul_2;
	Escribir "multiplos de 3 : ", mul_3;
	
FinAlgoritmo
