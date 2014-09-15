package com.journaldev.portlet;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class TitleChangedPortlet extends GenericPortlet{
	
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
		response.getWriter().println("My Name Is:"+this.getPortletName());
	}
	
	public void doEdit(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
		response.getWriter().println("Edit Mode On Portlet Name :"+this.getPortletName());
	}

	public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
		response.getWriter().println("Help Mode On Portlet Name :"+this.getPortletName());
	}
	
	public java.lang.String getTitle(RenderRequest request) {
		// Check whether the name of the portlet is programmaticTitleChangePortlet
		if(this.getPortletName().equals("ProgrammaticTitleChangePortlet")){
			// If it's like that, just get the defined bundle
			ResourceBundle bundle = this.getPortletConfig().getResourceBundle(new Locale("en"));
			// Retrun the string that's corresponded for anyTitle property
			return (String)bundle.getObject("anyTitle");
		}
		// else return the default, either that's defined in the portlet.xml or that's defined in the bundle
		return super.getTitle(request);
	}
}
