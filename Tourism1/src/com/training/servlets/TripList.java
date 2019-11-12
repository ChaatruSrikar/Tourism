package com.training.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.training.daos.TripDao;
import com.training.entities.Tripdetails;

public class TripList extends HttpServlet {
	private static final long serialVersionUID = 300L;
	private TripDao tDao;
	
    public TripList() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	Connection con = null;
		this.tDao = new TripDao(con);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		List<Tripdetails> allTripList = null;
		
		try {
			allTripList = tDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("TripList", allTripList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("triplist.jsp");
		
		dispatcher.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		List<Tripdetails> allTrips = null;
		
		try {
			allTrips = tDao.findByLocation(request.getParameter("nameSearch"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(allTrips==null||allTrips.isEmpty())
			request.setAttribute("searchResult", " Trip not found");
		
		request.setAttribute("TripList", allTrips);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("triplist.jsp");
		
		dispatcher.forward(request, response);
	}

}
