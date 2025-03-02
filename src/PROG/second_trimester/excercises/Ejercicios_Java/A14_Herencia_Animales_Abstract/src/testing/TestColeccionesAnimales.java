package testing;

import java.util.ArrayList;

import javabean.AbstractAnimal;
import javabean.Caballo;
import javabean.Gato;
import javabean.Perro;

public class TestColeccionesAnimales {

	public static void main(String[] args) {
		AbstractAnimal animal1 = new Caballo(1,"Equinus", 4,345);
		AbstractAnimal animal2 = new Caballo(2,"Equinus",4,234);
		Gato gato1 = new Gato(3,"Gato Felix", 4, 14);
		Gato gato2 = new Gato(4,"Gato con Botas", 4, 7);
		AbstractAnimal gato3 = new Gato(5,"Gato Montés",4, 20);
		Perro perro1 = new Perro(34, "Perrus", 4, "Lobo");
		AbstractAnimal perro2 = new Perro(45, "Perrus", 4, "Maltes");
		
		ArrayList<AbstractAnimal> zoo = new ArrayList<>();
		zoo.add(perro2);
		zoo.add(animal1);
		zoo.add(gato1);
		zoo.add(animal2);
		zoo.add(perro1);
		zoo.add(gato2);
		zoo.add(gato3);
		
		for (AbstractAnimal abstractAnimal: zoo) {
			abstractAnimal.sonido();
			abstractAnimal.saludar();
			if (abstractAnimal instanceof Gato) {
				((Gato)abstractAnimal).aumentarVidas(4);
			}
			System.out.println(abstractAnimal);
			
		}
		
		
		
		
		
		
		
		
		

	}

}
