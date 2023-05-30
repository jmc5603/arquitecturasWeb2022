package com.dao.practicas;

import java.util.List;

public interface DAO<T>{

	T get(int id);
	List<T> getAll();
	void insert(T object);
	void update(int id, String[] params);
	void delete(int id);
	
}
