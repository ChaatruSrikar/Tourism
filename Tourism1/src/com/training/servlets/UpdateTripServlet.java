package com.training.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.TripDao;
import com.training.entities.Tripdetails;
import com.training.utils.DBConnections;

public class UpdateTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private TripDao tDao;
	
    public UpdateTripServlet() {
        super();
        
        this.con = DBConnections.getOracleConnection();
    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strtourCode = request.getParameter("tripCode");
		
		String tourName = request.getParameter("tourName");
		
		String strtourstr = request.getParameter("Startdate");
		String strtourend = request.getParameter("enddate");
		
		String tourOrg = request.getParameter("origin");
		String tourDest = request.getParameter("Destination");
		
		String strtourCost = request.getParameter("Cost");
		
		double tourCost = Double.parseDouble(strtourCost);
		long tourCode = Long.parseLong(strtourCode);
		
		LocalDate tourStr = LocalDate.parse(strtourstr);
		LocalDate tourEnd = LocalDate.parse(strtourend);
		
		Tripdetails edited = new Tripdetails(tourCode,tourName,tourStr,tourEnd,tourOrg,tourDest,tourCost);
		
		String message = null;
		
		tDao = new TripDao(con);
		int add=0;
		
		
		try {
			add= tDao.add(edited);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(add==1) {
			message = "Updated Successfully";
		}
		else
			message = "Could not update";
		
		request.setAttribute("updatemessage", message);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
	}

}
