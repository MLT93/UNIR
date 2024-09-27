Algoritmo ejercicio2
	// Calcular el �rea, per�metro e hipotenusa de un tri�ngulo
	
	// Definimos las variables
	Definir cateto1, cateto2 Como Entero;
	//  NOTA: Area es producto de una divisi�n por tanto podemos esperar un Real, lo mismo para Hipotenusa que ser� producto 
	//  de una ra�z cuadrada. Per�metro al ser suma de Enteros con lo que podr�a ser un Real, debe ser tambi�n definido como Real.
	Definir hipotenusa, perimetro, area Como Real;
	
	// Inicializamos todas las variables a 0 por ser num�ricas
	cateto1 = 0;
	cateto2 = 0;
	area = 0;
	perimetro = 0;
	hipotenusa = 0;
	
	// Capturamos los datos de entrada, que son cateto1 y cateto2
	Escribir "Programa para calcular area, perimetro e hipotenusa de un tri�ngulo rect�ngulo.";
	Escribir "Introduce el primer cateto: ";
	Leer cateto1;
	Escribir "Introduce el segundo cateto: ";
	Leer cateto2;
	
	// Procedemos a realizar los c�lculos
	// Primero calcularemos el �rea (base por altura entre 2). En este caso, base y altura son los dos catetos.
	area = cateto1 * cateto2 / 2;
	// Seguidamente calculamos la hipotenusa (raiz de la suma de los catetos al cuadrado) ya que la necesitamos para el per�metro
	hipotenusa = raiz(cateto1^2 + cateto2^2);
	// Por �ltimo calculamos el per�metro, que ser� la suma de los catetos y la hipotenusa (es decir, los tres lados)
	perimetro = cateto1 + cateto2 + hipotenusa;
	
	// Mostramos los resultados obtenidos en consola y finalizamos el programa
	Escribir "Los resultados obtenidos para un tri�ngulo rect�ngulo de lados ", cateto1, " y ", cateto2,  " son los siguientes...";
	Escribir "Area del tri�ngulo: ", area;
	Escribir "Hipotenusa del tri�ngulo: ", hipotenusa;
	Escribir "Per�metro del tri�ngulo: ", perimetro;
	Escribir "Programa finalizado.";
	
FinAlgoritmo
