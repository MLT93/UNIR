package dao;

import java.util.ArrayList;
import java.util.List;

import javabean.Location;

public class LocationDaoImplList implements ILocationDao {
	
	private List<Location> lista;
	private ICountryDao iCountryDao;
	
	
	public LocationDaoImplList() {
		lista = new ArrayList<Location>();
		iCountryDao = new CountryDaoImplList();
		cargarDatos();
	}
	
	private void cargarDatos() {
		lista.add(new Location(1500, "pez 3", "28008", "Madrid", "Madrid", iCountryDao.findById("ES")));
		lista.add(new Location(1600, "nuez 3", "28016", "Madrid", "Madrid", iCountryDao.findById("ES")));
		lista.add(new Location(1700, "rosa 34", "19002", "Guadalajara", "Guadalajara", iCountryDao.findById("ES")));
		
	}

	@Override
	public Location findById(Integer atributoPk) {
		for (Location ele: lista) {
			if (ele.getLocationId() == atributoPk)
				return ele;
		}
		
		return null;
	}

	@Override
	public int insertOne(Location objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(Location objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer atributoPk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObj(Location objeto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Location> buscarPorCity(String cadena) {
		// TODO Auto-generated method stub
		List<Location> aux = new ArrayList<Location>();
		
		for (Location city: lista) {
			
			if (city.getCity().startsWith(cadena))
				aux.add(city);
			
		}
		
		
		return aux;
	}

	@Override
	public List<Location> buscarPorPostalCode(String cadena) {
		// TODO Auto-generated method stub
		List<Location> aux = new ArrayList<Location>();
		
		for (Location postalCode: lista) {
			
			if (postalCode.getPostalCode().startsWith(cadena))
				aux.add(postalCode);
			
		}
		
		
		return aux;
	}

	@Override
	public List<Location> buscarPorPais(String cadena) {
		// TODO Auto-generated method stub
		List<Location> aux = new ArrayList<Location>();
		
		for (Location pais: lista) {
			
			if (pais.getCountry().getCountryName().startsWith(cadena))
				aux.add(pais);
			
		}
		return aux;
	}

}
