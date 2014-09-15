package com.journaldev.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class HelloWorldPortlet extends GenericPortlet {
	private static int renderCount = 0;
	private static int actionCount = 0;

	public void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		
		synchronized(this){
			renderCount++;
		}
		response.getWriter().print("<form action="+response.createActionURL()+">"
				+ "<p>Render has executed "+renderCount+"</p>"
				+ "<p>Action has executed "+actionCount+"</p>"
				+ "<input type='submit'/>"
				+ "</form>");
	}

	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse){
		synchronized(this){
			actionCount++;
		}
	}
	
	
    public void init( PortletConfig config ) throws PortletException {
        super.init( config );
    }	
}
