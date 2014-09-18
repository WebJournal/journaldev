package com.journaldev.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class LifecyclePortlet implements Portlet {
	private static int renderCount = 0;
	private static int actionCount = 0;
	private static int initCount = 0;
	
	@Override
	public void init(PortletConfig config) throws PortletException {
		initCount++;	
	}
	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		synchronized(this){
			actionCount++;
		}
		response.sendRedirect(request.getContextPath()+"/index.html");
	}
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		synchronized(this){
			renderCount++;
		}
		
		response.getWriter().print("<form action="+response.createActionURL()+">"
				+ "<p> The number of initiated Portlets by the container is :: "+initCount+"</p>"
						+ "<p> The number of processed actions by the container is :: "+actionCount+"</p>"
								+ "<p> The number of achieved render by the container is :: "+renderCount+"</p>"
									+"<input value='Submit' type='submit'/><br/>"
										+ "<a href='"+response.createRenderURL()+"'>Render Again</a>"
											+ "</form>");
	}
	@Override
	public void destroy() {
		initCount--;
		System.out.println("The number of Portlets get deployed :: "+initCount);
	}
	
	
}
