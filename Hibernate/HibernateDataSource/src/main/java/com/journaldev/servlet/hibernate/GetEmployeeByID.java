package com.journaldev.servlet.hibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import com.journaldev.servlet.hibernate.model.Employee;

@WebServlet("/GetEmployeeByID")
public class GetEmployeeByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public final Logger logger = Logger.getLogger(GetEmployeeByID.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		logger.info("Request Param empId="+empId);
		
		SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, empId);
		tx.commit();
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        if(emp != null){
        out.print("<html><body><h2>Employee Details</h2>");
        out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
        out.print("<th>Employee ID</th>");
        out.print("<th>Employee Name</th>");
        out.print("<th>Employee Role</th>");
        
            out.print("<tr>");
            out.print("<td>" + empId + "</td>");
            out.print("<td>" + emp.getName() + "</td>");
            out.print("<td>" + emp.getRole() + "</td>");
            out.print("</tr>");
        out.print("</table></body><br/>");
        
        out.print("</html>");
        }else{
        	out.print("<html><body><h2>No Employee Found with ID="+empId+"</h2></body></html>");
        }
	}

}
