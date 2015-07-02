package com.total.acc.model.dao;

import java.util.List;

public interface GenericDAO<Clazz> {
	Clazz find(Integer id);
	void save (Clazz clazz);
	void update (Clazz clazz);
	void saveOrUpdate (Clazz clazz);
	List<Clazz> findAll();
	Integer countAll();
	void delete(Clazz clazz);	
}
