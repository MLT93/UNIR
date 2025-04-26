Algoritmo Calculo_Hipotenusa
	// Problema a resolver.
	//la hipotenusa de un triangulo rectangulo
	// hipotenusa  = raiz cuadrada, de la suma de los catetos al cuadrado
	//paso 1: identificacion y definicion de variables
	Definir hipotenusa Como Real;
	Definir cateto1, cateto2 Como Entero;
	// paso 2 inicio de variables numerico
	hipotenusa = 0;
	cateto1 = 0;
	cateto2 = 0;
	//paso 3: obtencion de los datos de las variables
	Leer cateto1;
	Leer cateto2;
	// paso 4 tratamiento de la informacion
	
	hipotenusa = raiz(cateto1 ^ 2 + cateto2 ^ 2);
	// paso 5: Informacion de resultado
	Escribir "hipotenusa : ", hipotenusa;

FinAlgoritmo
