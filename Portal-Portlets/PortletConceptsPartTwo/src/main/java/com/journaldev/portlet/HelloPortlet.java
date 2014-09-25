package com.journaldev.portlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

public class HelloPortlet extends GenericPortlet{
	Logger logger = Logger.getLogger(HelloPortlet.class);
	
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
	}
	
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException{
		// Get all attributes' names that are defined along side of Application Scope
		Enumeration<String> names = request.getPortletSession().getAttributeNames(PortletSession.APPLICATION_SCOPE);
		StringBuffer buffer = new StringBuffer();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			// Get the attribute's value
			buffer.append(name+" :: "+request.getPortletSession().getAttribute(name,PortletSession.APPLICATION_SCOPE)+"\n");
		}
		response.getWriter().print("<form action="+response.createActionURL()+">"
				+ "<p>Portlet Session Attributes</p>"
				+ buffer
				+ "<input type='submit' value='Just Do Action'/>"
				+ "</form>");
	}
	
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException{
		if(this.getPortletName().equals("HelloOne")){
			// Define attribute along side of Application Scope
			request.getPortletSession().setAttribute("anonymousObject", "PortletSession Attribute",PortletSession.APPLICATION_SCOPE);	
		}
	}
}
