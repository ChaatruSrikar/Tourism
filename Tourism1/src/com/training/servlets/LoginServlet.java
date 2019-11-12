package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.daos.UserDao;
import com.training.entities.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 100L;
	private UserDao uDao;
    public LoginServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	this.uDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		String message = null;
		
		try {
			User founduser = uDao.findByName(name);
			
			if(founduser==null || !(founduser.getPassword().equals(password)))
				message = "Invalid username or password";
			else {
				message = "Login Successfull";
				session.setAttribute("Username", founduser.getUserName());
				
				if(founduser.getCategory().equalsIgnoreCase("EMPLOYEE")) {
					session.setAttribute("Emp", true);
				}
				else
					session.setAttribute("Emp", false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("loginmessage", message);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
	}

}
