package com.journaldev.portlet;
 
import java.io.IOException;
 
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
 
public class HelloWorldPortlet extends GenericPortlet{
    public void doView( RenderRequest request, RenderResponse response )
            throws PortletException, IOException {
            response.getWriter().print("Jounral Dev Provides you Hello World Portlet !");
        }
}