Algoritmo sin_titulo
	//menos de 10000   salario minimo
	//10.000 a 30.000  salario bajo
	//30.000 a 60.000  salario medio
	//mas de 60.000     eres rico
	Definir salario Como Real;
	salario = 0;
	Escribir "Dime tu salario y no mientas";
	leer salario;
	Si salario < 10000 Entonces
		Escribir "salario minimo";
	SiNo
		Si salario >= 10000 Y salario < 30000 Entonces
			Escribir "salario bajo";
		SiNo
			Si salario >= 30000 Y salario <= 60000 Entonces
				Escribir "salario medio";
			SiNo
				Escribir "eres rico";
			Fin Si
		Fin Si
	Fin Si
FinAlgoritmo
