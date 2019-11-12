package com.training.ifaces;

import java.sql.SQLException;
import java.util.*;

public interface Dao<T> {

	public int add(T t) throws SQLException;
	
	public List<T> findAll() throws SQLException;
	
	public T findById(long id) throws SQLException;
	
	public int update(long id, T t) throws SQLException;
	
	public int remove(long id) throws SQLException;
}
