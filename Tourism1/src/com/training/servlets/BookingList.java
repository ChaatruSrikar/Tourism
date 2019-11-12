package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.BookingDao;
import com.training.entities.Booking;

public class BookingList extends HttpServlet {
	private static final long serialVersionUID = 600L;
	private BookingDao bDao;
	
    public BookingList() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		this.bDao = new BookingDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Booking> bookingList = new ArrayList<>();
		
		try {
			bookingList = bDao.findAll();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("bookingList", bookingList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("tripmanager.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
