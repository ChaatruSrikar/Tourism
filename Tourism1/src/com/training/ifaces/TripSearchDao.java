package com.training.ifaces;

import java.sql.SQLException;
import java.util.List;

import com.training.entities.Tripdetails;

public interface TripSearchDao<T> extends Dao<T> {

	public List<T> findByLocation(String location) throws SQLException;
}
