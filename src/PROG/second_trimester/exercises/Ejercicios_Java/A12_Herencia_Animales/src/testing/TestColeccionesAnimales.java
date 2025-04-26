package testing;

import java.util.ArrayList;

import javabean.Animal;
import javabean.Gato;
import javabean.Perro;

public class TestColeccionesAnimales {

	public static void main(String[] args) {
		Animal animal1 = new Animal(1,"HomoSapiens", 2);
		Animal animal2 = new Animal(2,"Ciempies", 100);
		Gato gato1 = new Gato(3,"Gato Felix", 4, 14);
		Gato gato2 = new Gato(4,"Gato con Botas", 4, 7);
		Animal gato3 = new Gato(5,"Gato Montés",4, 20);
		Perro perro1 = new Perro(34, "Perrus", 4, "Lobo");
		Animal perro2 = new Perro(45, "Perrus", 4, "Maltes");
		
		ArrayList<Animal> zoo = new ArrayList<>();
		zoo.add(perro2);
		zoo.add(animal1);
		zoo.add(gato1);
		zoo.add(animal2);
		zoo.add(perro1);
		zoo.add(gato2);
		zoo.add(gato3);
		
		for (Animal animal: zoo) {
			animal.sonido();
			animal.saludar();
			if (animal instanceof Gato) {
				((Gato)animal).aumentarVidas(4);
				
			}
			System.out.println(animal);
			
		}
		
		
		
		
		
		
		
		
		

	}

}
