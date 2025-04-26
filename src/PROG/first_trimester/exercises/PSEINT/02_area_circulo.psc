Algoritmo area_circulo
	// Problema a resolver.
	//Área de un círculo = ? r²
	
	
	//paso 1: identificacion y definicion de variables
	Definir radio Como Entero;
	Definir areaCirculo Como Real;
	// paso 2 inicio de variables numerico
	radio = 0;
	areaCirculo = 0;
	//paso 3: obtencion de los datos de las variables
	Escribir "Dame el radio como entrero de tu circulo";
	Leer radio;
	// paso 4 tratamiento de la informacion
	
	areaCirculo = PI * radio ^ 2;
	
	
	// paso 5: Informacion de resultado
	
	Escribir "el area de este circulo es : ", areaCirculo;
	
FinAlgoritmo
