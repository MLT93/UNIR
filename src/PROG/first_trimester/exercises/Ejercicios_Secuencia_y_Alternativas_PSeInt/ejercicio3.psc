Algoritmo ejercicio3
	// Calcular la circunferencia (per�metro del c�rculo) y el �rea del c�rculo que esta define
	
	// Definimos las variables
	Definir radio Como Entero;
	Definir circunferencia, area Como Real;
	
	// Inicializamos las variables num�ricas a 0
	radio = 0;
	circunferencia = 0;
	area = 0;
	
	// Capturamos el radio por consola
	Escribir "Programa para calcular la circunferencia y el �rea del c�rculo definido por esta.";
	Escribir "Introduce el radio: ";
	Leer radio;
	
	// Procedemos a realizar los c�lculos
	circunferencia = 2 * PI * radio;
	area = PI * radio^2;
	
	// Mostramos los resultados por consola y finalizamos el programa
	Escribir "Para un radio ", radio, " los resultados son...";
	Escribir "Circunferencia: ", circunferencia;
	Escribir "�rea: ", area;
	Escribir "Finalizar programa";
	
FinAlgoritmo
