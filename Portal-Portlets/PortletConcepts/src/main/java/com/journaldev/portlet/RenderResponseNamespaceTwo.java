package com.journaldev.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class RenderResponseNamespaceTwo extends GenericPortlet{
	
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		response.getWriter().println("<html>"
				+ "<head>"
				+ "<script>"
				+ "var "+response.getNamespace()+"message = 'Handle Submit, Portlet Two';"
				+ "function "+response.getNamespace()+"handleSubmit(){"
				+ " alert('Handle Submit, The Portlet Is '+"+response.getNamespace()+"message);"
				+ "}"
				+ "</script>"
				+ "</head>"
				+ "<form action="+response.createActionURL()+">"
				+ "  <input type='button' value='Click On Me' onclick='"+response.getNamespace()+"handleSubmit()'/>"
				+ "</form>"
				+ "</html>");

	}
	
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		System.out.println("Handled Request ..");
	}
}
