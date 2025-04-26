package testing;

import java.util.ArrayList;

import javabean.AbstractAnimal;
import javabean.Caballo;
import javabean.Gato;
import javabean.Perro;

public class TestAnimal {

	public static void main(String[] args) {
		// creacion de variables de tipo Animal, que instancian(new) objetos de Animal
		AbstractAnimal animal1 = new Caballo(1,"Equinus", 4,345);
		AbstractAnimal animal2 = new Caballo(2,"Equinus",4,234);
		
		// creacion de variables de tipo Gato, que instancian(new) objetos de Gato
		Gato gato1 = new Gato(3,"Gato Felix", 4, 14);
		Gato gato2 = new Gato(4,"Gato con Botas", 4, 7);
		
		// creacion de variables de tipo Animal(clase padre), 
		// instanciando(new) objetos de Gato (clases hijo)
		
		AbstractAnimal gato3 = new Gato(5,"Gato Montés",4, 20);
		
		/*
		 * MOMENTOS DE LA PROGRAMACION DE UNA APLICACION
		 * MOMENTO 1: Estoy tecleando
		 *    cuando a gato3 le pongo un punto que metodos veo 
		 * MOMENTO 2: Estoy ejecutando
		 * que métod se ejecuta, el de quien
		 */
		System.out.println("DATOS DE GATO 3");
		gato3.sonido();
		gato3.saludar();
		System.out.println(gato3);
		((Gato)gato3).cancelarVidas(4);
		System.out.println(gato3);
		
		Gato gato4 = (Gato) gato3;
		
		System.out.println(gato4);
		
		
		
		System.out.println("DATOS ANIMAL 1");
		animal1.saludar();
		animal1.sonido();
		System.out.println(animal1);

		System.out.println("DATOS ANIMAL 2");
		animal2.saludar();
		animal2.sonido();
		System.out.println(animal2);
		
		System.out.println("DATOS GATO 1");
		gato1.saludar();
		gato1.sonido();
		gato1.aumentarVidas(3);
		System.out.println(gato1);
		
		
		System.out.println("COLECCION DE GATOS");
		ArrayList<Gato> censoGatos = new ArrayList<Gato>();
		censoGatos.add(gato1);
		censoGatos.add(gato2);
		censoGatos.add(new Gato(12, "Gato Siames", 4, 7));
		
		for (Gato gato: censoGatos) {
			System.out.println("Vidas = " + gato.getNumeroVidas());
		}
		
		
		
		
		
		
		
	}

}
