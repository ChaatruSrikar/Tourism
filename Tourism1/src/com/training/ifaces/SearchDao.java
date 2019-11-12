package com.training.ifaces;

import java.sql.SQLException;

public interface SearchDao<T> extends Dao<T> {

	public T findByName(String name) throws SQLException;
	
	public boolean validate(String uName, String pWord) throws SQLException;
}
