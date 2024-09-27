Algoritmo ejercicio2
	// Calcular el área, perímetro e hipotenusa de un triángulo
	
	// Definimos las variables
	Definir cateto1, cateto2 Como Entero;
	//  NOTA: Area es producto de una división por tanto podemos esperar un Real, lo mismo para Hipotenusa que será producto 
	//  de una raíz cuadrada. Perímetro al ser suma de Enteros con lo que podría ser un Real, debe ser también definido como Real.
	Definir hipotenusa, perimetro, area Como Real;
	
	// Inicializamos todas las variables a 0 por ser numéricas
	cateto1 = 0;
	cateto2 = 0;
	area = 0;
	perimetro = 0;
	hipotenusa = 0;
	
	// Capturamos los datos de entrada, que son cateto1 y cateto2
	Escribir "Programa para calcular area, perimetro e hipotenusa de un triángulo rectángulo.";
	Escribir "Introduce el primer cateto: ";
	Leer cateto1;
	Escribir "Introduce el segundo cateto: ";
	Leer cateto2;
	
	// Procedemos a realizar los cálculos
	// Primero calcularemos el área (base por altura entre 2). En este caso, base y altura son los dos catetos.
	area = cateto1 * cateto2 / 2;
	// Seguidamente calculamos la hipotenusa (raiz de la suma de los catetos al cuadrado) ya que la necesitamos para el perímetro
	hipotenusa = raiz(cateto1^2 + cateto2^2);
	// Por último calculamos el perímetro, que será la suma de los catetos y la hipotenusa (es decir, los tres lados)
	perimetro = cateto1 + cateto2 + hipotenusa;
	
	// Mostramos los resultados obtenidos en consola y finalizamos el programa
	Escribir "Los resultados obtenidos para un triángulo rectángulo de lados ", cateto1, " y ", cateto2,  " son los siguientes...";
	Escribir "Area del triángulo: ", area;
	Escribir "Hipotenusa del triángulo: ", hipotenusa;
	Escribir "Perímetro del triángulo: ", perimetro;
	Escribir "Programa finalizado.";
	
FinAlgoritmo
