package dao;

import java.util.List;

import javabean.Location;

public interface ILocationDao extends ICrudGenerico<Location, Integer>{
	
	List<Location> buscarPorCity(String cadena);
	List<Location> buscarPorPostalCode(String cadena);
	List<Location> buscarPorPais(String cadena);
}
