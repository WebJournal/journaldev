package com.journaldev.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.journaldev.servlet.dao.UserDAO;
import com.journaldev.servlet.dao.UserDAOImpl;
import com.journaldev.servlet.model.User;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -4602272917509602701L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String error;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setEmail(email); user.setPassword(password);
		
		HttpSession session = request.getSession();
		UserDAO userDAO = new UserDAOImpl();

		User userDB = userDAO.loginUser(user);

		if (userDB.getName() == null) {
			error = "Invalid Email or password";
			session.setAttribute("error", error);
			response.sendRedirect("index.jsp");
		} else {
			session.setAttribute("user", userDB.getName());
			session.removeAttribute("error");
			response.sendRedirect("welcome.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ("logout".equalsIgnoreCase(request.getParameter("param"))) {
			HttpSession session = request.getSession();
			if(session != null){
			session.invalidate();
			}
			response.sendRedirect("index.jsp");
		}
	}
}