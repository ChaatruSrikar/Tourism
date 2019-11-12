package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.entities.Booking;
import com.training.ifaces.Dao;
import com.training.utils.DBConnections;

public class BookingDao implements Dao<Booking> {

	private Connection con;
	
	public BookingDao() {
		super();
		this.con = DBConnections.getOracleConnection();
	}
	
	private Booking getFromResultSet(ResultSet rs) throws SQLException {
		
		long code = rs.getLong("CODE");
		String uName = rs.getString("users");
		long Bookingnumber = rs.getLong("BOOKINGnumber");
		
		return new Booking(code, uName, Bookingnumber);		
	}

	@Override
	public int add(Booking t) throws SQLException {
		String sql = "INSERT INTO BOOKING36 VALUES (?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setLong(1, t.getCode());
		pstmt.setString(2, t.getUser());
		pstmt.setLong(3, t.getBookingNumber());
		
		return pstmt.executeUpdate();
	}

	@Override
	public List<Booking> findAll() throws SQLException {
		List<Booking> bookingsList = new ArrayList<>();
		
		String sql = "SELECT * FROM BOOKING36";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			bookingsList.add(getFromResultSet(rs));
		}
		
		return bookingsList;
	}

	@Override
	public Booking findById(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(long id, Booking t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(long id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
