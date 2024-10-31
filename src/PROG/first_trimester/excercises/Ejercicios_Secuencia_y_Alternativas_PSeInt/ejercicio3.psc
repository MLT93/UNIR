Algoritmo ejercicio3
	// Calcular la circunferencia (perímetro del círculo) y el área del círculo que esta define
	
	// Definimos las variables
	Definir radio Como Entero;
	Definir circunferencia, area Como Real;
	
	// Inicializamos las variables numéricas a 0
	radio = 0;
	circunferencia = 0;
	area = 0;
	
	// Capturamos el radio por consola
	Escribir "Programa para calcular la circunferencia y el área del círculo definido por esta.";
	Escribir "Introduce el radio: ";
	Leer radio;
	
	// Procedemos a realizar los cálculos
	circunferencia = 2 * PI * radio;
	area = PI * radio^2;
	
	// Mostramos los resultados por consola y finalizamos el programa
	Escribir "Para un radio ", radio, " los resultados son...";
	Escribir "Circunferencia: ", circunferencia;
	Escribir "Área: ", area;
	Escribir "Finalizar programa";
	
FinAlgoritmo
