package com.journaldev.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.journaldev.servlet.dao.UserDAO;
import com.journaldev.servlet.dao.UserDAOImpl;
import com.journaldev.servlet.model.User;

public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = -4006561145676424435L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");

		if ((name == null || "".equals(name))
				|| (email == null || "".equals(email))
				|| (password == null || "".equals(password))
				|| (address == null || "".equals(address))) {
			String error = "Mandatory Parameters Missing";
			request.getSession().setAttribute("errorReg", error);
			response.sendRedirect("index.jsp#register");
		} else {
			User user = new User(name, email, password, address);

			UserDAO userDAO = new UserDAOImpl();

			int result = userDAO.createUser(user);
			if (result == 1) {
				request.getSession().removeAttribute("errorReg");
				response.sendRedirect("success.jsp");
			}else{
				request.getSession().setAttribute("errorReg", "Internal Server Error, Please try again later.");
				response.sendRedirect("index.jsp#register");
			}
		}
	}
}