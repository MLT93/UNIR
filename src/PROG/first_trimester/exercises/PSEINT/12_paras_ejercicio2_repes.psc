Algoritmo sin_titulo
	//Leer consecutivamente dos números cada vez, hasta que los dos sean -1. Comparar los dos
	//números leídos e informar cada vez si son iguales, mayor o menor (el primero respecto al segundo). 
	//	Al final del proceso informar cuantas veces los números eran iguales, cuantas veces el
	//		primero era mayor del segundo y cuantas veces el primero era menor del segundo número leído.
	
	Definir numero1, numero2,cont_mayores,cont_menores, cont_iguales Como Entero;
	numero1=0; numero2=0; cont_iguales=0; cont_mayores=0; cont_menores=0;
	Escribir "dame un numero entero";
	leer numero1;
	Escribir "dame otro numero entero para comparar";
	leer numero2;
	
	Mientras numero1 <> -1 O numero2 <> -1 Hacer
		Si numero1 > numero2 Entonces
			Escribir "numero1 es mayor que numero2";
			cont_mayores = cont_mayores + 1;
		SiNo
			Si numero1 < numero2 Entonces
				Escribir "numero1 es menor que numero2";
				cont_menores = cont_menores + 1;
			SiNo
				Escribir "numero1 es igual que numero2";
				cont_iguales = cont_iguales + 1;
			Fin Si
		Fin Si
		
		Escribir "dame un numero entero";
		leer numero1;
		Escribir "dame otro numero entero para comparar";
		leer numero2;	
	Fin Mientras
	
	
	//Estadisticas
	
	Escribir "numero de mayores : ", cont_mayores;
	Escribir "numero de menores : ", cont_menores;
	Escribir "numero de iguales : ", cont_iguales;
	

FinAlgoritmo
