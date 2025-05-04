package modelo.dao;

import java.util.List;

public interface IGenericCRUD<T, ID> {

	// Para el CRUD
	List<T> findAll();
	T findById(ID atributoPK);
	int insertOne(T obj);
	int updateOne(T obj);
	int deleteById(ID atributoPK);
}
