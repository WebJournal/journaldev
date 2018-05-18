package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@ManagedBean(name="menuButtonManagedBean")
@SessionScoped
public class MenuButtonManagedBean {
	private MenuModel menuButton = new DefaultMenuModel();
	
	public MenuButtonManagedBean(){
		
		// Create menuitems required
		DefaultMenuItem ajaxAction = new DefaultMenuItem("Ajax Action");
		ajaxAction.setUpdate("message");
		ajaxAction.setCommand("#{menubarManagedBean.ajaxAction}");
		
		DefaultMenuItem nonAjaxAction = new DefaultMenuItem("Non Ajax Action");
		nonAjaxAction.setAjax(false);
		nonAjaxAction.setCommand("#{menubarManagedBean.nonAjaxAction}");
		
		DefaultMenuItem urlAction = new DefaultMenuItem("Go To JournalDev");
		urlAction.setUrl("http://www.journaldev.com");
		
		this.menuButton.addElement(ajaxAction);
		this.menuButton.addElement(nonAjaxAction);
		this.menuButton.addElement(urlAction);
		
	}

	public MenuModel getMenuButton() {
		return menuButton;
	}

	public void setMenuButton(MenuModel menuButton) {
		this.menuButton = menuButton;
	}

	public String ajaxAction(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajax Update"));
		return "";
	}
	
	public String nonAjaxAction(){
		return "";
	}
}
