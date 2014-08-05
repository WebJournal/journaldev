package com.journaldev.prime.faces.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;

@ManagedBean
@SessionScoped
public class TagCloudManagedBean {
	private TagCloudModel tagCloud = new DefaultTagCloudModel();
	
	public TagCloudManagedBean(){
		// Create set of TagCloudItem (s)
		TagCloudItem primefaces = new DefaultTagCloudItem("Primefaces","http://www.journaldev.com/dev/primefaces", 10);
		TagCloudItem hibernate = new DefaultTagCloudItem("Hibernate","http://www.journaldev.com/dev/hibernate", 5);
		TagCloudItem apachePluto = new DefaultTagCloudItem("Apache Pluto", 3);
		TagCloudItem spring = new DefaultTagCloudItem("Spring", 4);
		TagCloudItem grails = new DefaultTagCloudItem("Grails", 5);
		TagCloudItem apacheLvy = new DefaultTagCloudItem("Apache lvy", 6);
		// Add created TagCloudItems into your TagCloudModel
		this.tagCloud.addTag(primefaces);
		this.tagCloud.addTag(hibernate);
		this.tagCloud.addTag(apachePluto);
		this.tagCloud.addTag(spring);
		this.tagCloud.addTag(grails);
		this.tagCloud.addTag(apacheLvy);
	}

	public TagCloudModel getTagCloud() {
		return tagCloud;
	}

	public void setTagCloud(TagCloudModel tagCloud) {
		this.tagCloud = tagCloud;
	}
	
	public void selectListener(SelectEvent e){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(((TagCloudItem)e.getObject()).getLabel() + " Is Selected"));
	}
	
	public String listAllTags(){
		List<TagCloudItem> tags = this.tagCloud.getTags();
		String message = "";
		for(TagCloudItem item : tags){
			message = message + ","+item.getLabel();
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Your Tags Are: "+message));
		return "";
	}

}
