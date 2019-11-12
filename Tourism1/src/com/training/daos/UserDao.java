package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.training.entities.User;
import com.training.ifaces.SearchDao;
import com.training.utils.DBConnections;

public class UserDao implements SearchDao<User> {
	
	private Connection con;
	
	public UserDao() {
		super();
		this.con = DBConnections.getOracleConnection();
	}

	@Override
	public int add(User t) throws SQLException {

		String sql = "INSERT INTO USER79 VALUES (?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setLong(1, t.getId());
		pstmt.setString(2, t.getUserName());
		pstmt.setString(3, t.getPassword());
		pstmt.setString(4, t.getCategory());
				
		return pstmt.executeUpdate();
	}

	@Override
	public List<User> findAll() throws SQLException {
		
		return null;
	}

	@Override
	public User findById(long id) throws SQLException {

		return null;
	}

	@Override
	public int update(long id, User t) throws SQLException {

		String sql = "UPDATE USER79 SET USERNAME=?, PASSWORD=?, CATEGORY=? WHERE ID= ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, t.getUserName());
		pstmt.setString(2, t.getPassword());
		pstmt.setString(3, t.getCategory());
		pstmt.setLong(4, id);
				
		return pstmt.executeUpdate();
	}

	@Override
	public int remove(long id) throws SQLException {

		String sql = "DELETE USER79 WHERE ID = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setLong(1,id);
		
		return pstmt.executeUpdate();
	}

	@Override
	public User findByName(String searchuser) throws SQLException {
		User found = null;
		
		String sql = "SELECT * FROM USER79 WHERE USERNAME = ?";
		
		PreparedStatement prstmt = con.prepareStatement(sql);
		
		prstmt.setString(1, searchuser);
		
		ResultSet resultset = prstmt.executeQuery();
		
		if(resultset.next()) {
			long id = resultset.getLong("ID");
			String userName = resultset.getString("USERNAME");
			String password = resultset.getString("PASSWORD");
			String category = resultset.getString("CATEGORY");
			
			found = new User(id, userName, password, category);
		}
		return found;
	}

	@Override
	public boolean validate(String uName, String pWord) throws SQLException {
		boolean validUser = false;
		
		String sql = "SELECT PASSWORD FROM USER79 WHERE USERNAME = ?";
		
		PreparedStatement prstmt = con.prepareStatement(sql);
		
		prstmt.setString(1, uName);
		
		ResultSet resultSet = prstmt.executeQuery();
		
		if(resultSet.next() && pWord.equals(resultSet.getString("PASSWORD"))) {
			validUser = true;
		}
		
		return validUser;
	}

	
	
}
