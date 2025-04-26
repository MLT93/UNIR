Algoritmo area_triangulo
	// calcular el area de un triangulo: AT= base*altura / 2.
	
	//paso 1: identificacion y definicion de variables
 	Definir area Como Real;
	Definir base, altura como Entero;
	// paso 2 inicio de variables numerico
	area = 0;
	base = 0;
	altura = 0;
	Escribir "Este progra te calcula El area del triangulo";
	Escribir "============================================";
	
	//paso 3: obtencion de los datos de las variables
	Escribir "Introduce la base del triangulo";
	leer base;
	Escribir "Introduce la altura del triangulo";
	leer altura;
	// paso 4 tratamiento de la informacion
	area = base * altura / 2;
	// paso 5: Informacion de resultado
	Escribir "El area es : ", area;
	
	Escribir "FIN DE PROGRAMA";
FinAlgoritmo
