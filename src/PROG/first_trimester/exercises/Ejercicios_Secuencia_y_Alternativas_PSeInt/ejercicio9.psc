Algoritmo ejercicio9
	// Leer dos n�meros y una palabra. Seg�n la palabra sea triangulo, rectangulo
	// o circulo se calculan area, perimetro y area o circunferencia y area.
	
	// Definimos las variables
	Definir numero1, numero2 Como Entero;
	Definir area, perimetro, circunferencia como Real;
	Definir figura Como Caracter;
	
	// Inicializamos variables num�ricas a 0
	numero1 = 0;
	numero2 = 0;
	area = 0;
	perimetro = 0;
	circunferencia = 0;
	
	// Capturamos los datos de entrada
	Escribir "Programa de c�lculos geom�tricos.";
	Escribir "Introduce un n�mero: ";
	Leer numero1;
	Escribir "Introduce otro n�mero: ";
	Leer numero2;
	Escribir "Introduce figura geom�trica (triangulo, rectangulo o circulo): ";
	Leer figura;
	
	// Procesamos los datos de entrada y finalizamos la ejecuci�n
	Segun figura Hacer	
		"triangulo":
			area = numero1 * numero2 / 2;
			Escribir "El �rea del tri�ngulo es ", area;
		"rectangulo":
			area = numero1 * numero2;
			perimetro = ( numero1 * 2 ) + ( numero2 * 2 );
			Escribir "El �rea del rect�ngulo es ", area, " y el per�metro es ", perimetro;
		"circulo":
			circunferencia = 2 * PI * numero1;
			area = PI * numero2^2;
			Escribir "La circunferencia para radio ", numero1, " es ", circunferencia;
			Escribir "El �rea para radio ", numero2, " es ", area;
		De Otro Modo:
			Escribir "Figura desconocida.";
	FinSegun
	
FinAlgoritmo
