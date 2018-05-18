package com.journaldev.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/GetCookie")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Cookie[] requestCookies = request.getCookies();
		
		out.write("<html><head></head><body>");
		out.write("<h3>Hello Browser!!</h3>");
		if(requestCookies != null){
		out.write("<h3>Request Cookies:</h3>");
		for(Cookie c : requestCookies){
			out.write("Name="+c.getName()+", Value="+c.getValue()+", Comment="+c.getComment()
					+", Domain="+c.getDomain()+", MaxAge="+c.getMaxAge()+", Path="+c.getPath()
					+", Version="+c.getVersion());
			out.write("<br>");
			//delete cookie
			if(c.getName().equals("Test")){
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		}
		out.write("</body></html>");
	}

}
