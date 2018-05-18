package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSeparator;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@SessionScoped
public class MenubarManagedBean {
	
	private MenuModel menubar = new DefaultMenuModel();
	
	public MenubarManagedBean(){
		// Create submenus required
		DefaultSubMenu file = new DefaultSubMenu("File");
		DefaultSubMenu open = new DefaultSubMenu("Open");
		DefaultSubMenu help = new DefaultSubMenu("Help");
		
		// Create menuitems required
		DefaultMenuItem edit = new DefaultMenuItem("Edit");
		DefaultMenuItem exit = new DefaultMenuItem("Exit");
		
		// Create menuitems required
		DefaultMenuItem ajaxAction = new DefaultMenuItem("Ajax Action");
		ajaxAction.setUpdate("message");
		ajaxAction.setCommand("#{menubarManagedBean.ajaxAction}");
		
		DefaultMenuItem nonAjaxAction = new DefaultMenuItem("Non Ajax Action");
		nonAjaxAction.setAjax(false);
		nonAjaxAction.setCommand("#{menubarManagedBean.nonAjaxAction}");
		
		DefaultMenuItem urlAction = new DefaultMenuItem("Go To JournalDev");
		urlAction.setUrl("http://www.journaldev.com");
		
		DefaultMenuItem about = new DefaultMenuItem("About JournalDev");
		DefaultMenuItem contactUs = new DefaultMenuItem("Contact Us");
		DefaultMenuItem helpMenuItem = new DefaultMenuItem("Help");
		
		// Associate menuitems with open submenu
		open.addElement(ajaxAction);
		open.addElement(nonAjaxAction);
		open.addElement(urlAction);
		
		// Associate menuitems with help submenu
		help.addElement(about);
		help.addElement(contactUs);
		help.addElement(new DefaultSeparator());
		help.addElement(helpMenuItem);
		
		// Associate open submenu with file submenu
		file.addElement(open);
		file.addElement(edit);
		file.addElement(new DefaultSeparator());
		file.addElement(exit);
		
		// Associate submenus with the menubar
		this.menubar.addElement(file);
		this.menubar.addElement(help);
		
	}

	public MenuModel getMenubar() {
		return menubar;
	}



	public void setMenubar(MenuModel menubar) {
		this.menubar = menubar;
	}



	public String ajaxAction(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajax Update"));
		return "";
	}
	
	public String nonAjaxAction(){
		return "";
	}
}
