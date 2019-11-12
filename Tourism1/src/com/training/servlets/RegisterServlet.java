package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.training.daos.UserDao;
import com.training.entities.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 200L;
	private UserDao uDao;
    public RegisterServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
    	uDao = new UserDao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String category = request.getParameter("usercategory");
		
		long id = (long)Math.floor(Math.random()*2000);
		
		User user = new User(id,username,password,category);

		String message = null;
		try {
			if(uDao.add(user)!=0)
				message = "New user registered";
			else
				message = "Could not add user";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("regmessage", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);	
	}

}
