package testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class TrabajarConColecciones {
	
	public static void main(String[] args) {
		List<String> nombres, palabras;
		
		nombres = new ArrayList<String>();
		 
	//	nombres = List.of("tomas", "andres", "eva", "sara", "carlos", "tomas");
		nombres.add("tomas");
		nombres.add("esteban");
		nombres.add("eva");
		nombres.add("sebastian");
		nombres.add("tomas");
		
		System.out.println("DE LIST");
		for (String nombre: nombres) {
			System.out.println(nombre);
		}
		
		palabras = new LinkedList<String>();
		
		Set<String> otrosNombres = new HashSet<String>();
		
//		otrosNombres.add("tomas");
		otrosNombres.add("eva");
		otrosNombres.add("antonio");
		otrosNombres.add("tomas");
		System.out.println("DE SET");
		for (String nombre: otrosNombres) {
			System.out.println(nombre);
		}
		
		
		System.out.println("DE MAP");
		
		Map<Integer, String> mapa = new HashMap<Integer, String>();
		
		mapa.put(1, "Casillas");
		mapa.put(2, "Carvajal");
		mapa.put(4, "Sergio Ramos");
		mapa.put(9, "Levandosky");
		mapa.put(4, "Hierro");
		System.out.println();
		for (Integer numero: mapa.keySet()) {
			System.out.println(numero);
			System.out.println(mapa.get(numero));
		}
		
		for (String jugador: mapa.values()) {
			System.out.println(jugador);
		}
		
		System.out.println("NOMBRES DEL METODO");
		List<String>  lista= getNombres();
		
		for (String nombre: lista) {
	//	for (String nombre: getNombres()) {
			
			System.out.println("Nombre rarito : " + nombre);
		}
		 
	
	}
	
	public static List<String> getNombres(){
		List<String> misNombres = new ArrayList<String>();
		misNombres.add("Gorgonio");
		misNombres.add("Sindulfo");
		misNombres.add("Gregorio");
		return misNombres;
		
		
		
	}

}
