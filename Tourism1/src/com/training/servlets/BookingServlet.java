package com.training.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.daos.BookingDao;
import com.training.daos.TripDao;
import com.training.entities.Booking;

public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 400L;
	private TripDao tDao;

    public BookingServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	
    	Connection con = null;
		this.tDao = new TripDao (con);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		long tourId = (Long)session.getAttribute("bookingId");
		String user = (String)session.getAttribute("Username");
		long bookings = (Long)session.getAttribute("bookings");
		
		Booking newBooking = new Booking(tourId,user,bookings);
		
		BookingDao bDao = new BookingDao();
		String message = null;
		try {
			if(bDao.add(newBooking)!=0)
				message = "Booking successful";
			else
				message = "Booking Unsuccessful";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("bookmessage", message);
		
		session.setAttribute("bookingId",null);
		session.setAttribute("bookings",null);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		
		String strID = request.getParameter("tours");
		String bookNum = request.getParameter("bookings");
		long id = Long.parseLong(strID);
		long bookings = Long.parseLong(bookNum);
		
		session.setAttribute("bookingId", id);
		session.setAttribute("bookings", bookings);
		
		try {
			double perCost = tDao.findById(id).getCost();
			String tourName = tDao.findById(id).getTourName();
			double bookingCost = Math.round(perCost*bookings);
			request.setAttribute("BookingCost", bookingCost);
			request.setAttribute("Tour", tourName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("booking.jsp");
		dispatcher.forward(request, response);
	}

}
