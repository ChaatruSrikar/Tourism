package com.training.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.training.entities.Tripdetails;
import com.training.ifaces.TripSearchDao;
import com.training.utils.DBConnections;

public class TripDao implements TripSearchDao<Tripdetails> {

	private Connection con;
	
	public TripDao(Connection con) {
		super();
		this.con = DBConnections.getOracleConnection();
	}
	
	private Tripdetails getFromResSet(ResultSet rs) throws SQLException {
		
		long tripCode = rs.getLong("TRIPCODE");
		String tripName = rs.getString("TOURNAME");
		Date startDate = rs.getDate("STARTDATE");
		Date endDate = rs.getDate("ENDDATE");
		String origin = rs.getString("ORIGIN");
		String dstn = rs.getString("DESTINATION");
		double cost = rs.getDouble("COST");
		
		LocalDate startDay = null;
		LocalDate endDay = null;
		
		if(startDate!=null)
			startDay = startDate.toLocalDate();
		if(endDate!=null)
			endDay = endDate.toLocalDate();
		
		return new Tripdetails(tripCode,tripName,startDay,endDay,origin,dstn,cost);
	}

	@Override
	public int add(Tripdetails t) throws SQLException {
		String sql = "INSERT INTO TRIP79 VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = this.con.prepareStatement(sql);
		
		pstmt.setLong(1, t.getTripCode());
		pstmt.setString(2, t.getTourName());
		pstmt.setDate(3, Date.valueOf(t.getStartDate()));
		pstmt.setDate(4, Date.valueOf(t.getEndDate()));
		pstmt.setString(5, t.getOrigin());
		pstmt.setString(6, t.getDestination());
		pstmt.setDouble(7,t.getCost());
				
		return pstmt.executeUpdate();
	}

	@Override
	public List<Tripdetails> findAll() throws SQLException {
		List<Tripdetails> tripList = new ArrayList<>();
		
		String sql = "SELECT * FROM TRIP79";
		
		PreparedStatement pstmt = this.con.prepareStatement(sql);
		
		ResultSet resSet = pstmt.executeQuery();
		
		while(resSet.next()) {
			tripList.add(getFromResSet(resSet));
		}
		
		return tripList;
	}

	@Override
	public Tripdetails findById(long id) throws SQLException {
		String sql = "SELECT * FROM TRIP79 WHERE TRIPCODE=?";
		
		PreparedStatement pstmt = this.con.prepareStatement(sql);
		pstmt.setLong(1,id);
		
		ResultSet resSet = pstmt.executeQuery();
		
		Tripdetails foundTrip = null;
		
		if(resSet.next()) {
			foundTrip = getFromResSet(resSet);
		}
		
		return foundTrip;
	}

	@Override
	public int update(long id, Tripdetails t) throws SQLException {
		String sql = "UPDATE TRIP79 SET TOURNAME = ?, STARTDATE = ?, ENDDATE = ?, ORIGIN = ?, DESTINATION = ?, COST = ? WHERE TRIPCODE=?";
		
		PreparedStatement pstmt = this.con.prepareStatement(sql);
		
		pstmt.setString(1, t.getTourName());
		pstmt.setDate(2, Date.valueOf(t.getStartDate()));
		pstmt.setDate(3, Date.valueOf(t.getEndDate()));
		pstmt.setString(4, t.getOrigin());
		pstmt.setString(5, t.getDestination());
		pstmt.setDouble(6,t.getCost());
		pstmt.setLong(7, t.getTripCode());
		
		
		return pstmt.executeUpdate();
	}

	@Override
	public int remove(long id) throws SQLException {
		String sql = "DELETE FROM TRIP79 WHERE TRIPCODE=?";
		
		PreparedStatement pstmt = this.con.prepareStatement(sql);
		pstmt.setLong(1, id);
		
		return pstmt.executeUpdate();
	}

	@Override
	public List<Tripdetails> findByLocation(String name) throws SQLException {
		List<Tripdetails> foundTrips = new ArrayList<>();
				
		String sql = "SELECT * FROM TRIP79 WHERE UPPER(ORIGIN) = UPPER(?) OR UPPER(DESTINATION) = UPPER(?)";
		
		PreparedStatement pstmt = this.con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, name);
		
		ResultSet resset = pstmt.executeQuery();
		
		while(resset.next()) {
			foundTrips.add(getFromResSet(resset));
		}
		
		return foundTrips;
	}

	
}
