package com.journaldev.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class RegisterEmployeePortlet extends GenericPortlet{
	
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		if(request.getParameter("status") == null){
			PortletRequestDispatcher dispatcher = this.getPortletContext().getRequestDispatcher("/register/register.php?actionUrl="+
					response.createActionURL());
			dispatcher.include(request, response);	
		}
		else {
			if(request.getParameter("status").equals("success")){
				PortletRequestDispatcher dispatcher = this.getPortletContext().getRequestDispatcher("/register/success.php?renderUrl="+
						response.createRenderURL());
				dispatcher.include(request, response);	
			}
			else {
				PortletRequestDispatcher dispatcher = this.getPortletContext().getRequestDispatcher("/register/failure.php?renderUrl="+
						response.createRenderURL()+"&exception="+request.getParameter("exception"));
				dispatcher.include(request, response);	
			}
		}
	}
	
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException{
		// Create request dispatcher
		PortletRequestDispatcher dispatcher =  this.getPortletContext().getNamedDispatcher("RegisterEmployeeServlet");
		try {
			// Include
			dispatcher.include(request, response);
			// Set render parameter
			response.setRenderParameter("status", "success");
		}
		catch(Exception ex){
			// Set render parameter
			response.setRenderParameter("status", "failed");
			response.setRenderParameter("exception", ex.getMessage());
		}
	}
}
