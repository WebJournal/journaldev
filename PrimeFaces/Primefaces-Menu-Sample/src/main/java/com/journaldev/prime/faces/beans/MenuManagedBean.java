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
public class MenuManagedBean {
	private MenuModel menu = new DefaultMenuModel();
	
	public MenuManagedBean(){
		// Create submenu
		DefaultSubMenu file = new DefaultSubMenu("File");
		// Create submenu
		DefaultSubMenu help = new DefaultSubMenu("Help");		
		// Create menuitem
		DefaultMenuItem open = new DefaultMenuItem("Open");
		// Create menuitem
		DefaultMenuItem edit = new DefaultMenuItem("Edit");
		// Create menuitem
		DefaultMenuItem exit = new DefaultMenuItem("Exit");
		
		// Create menuitem
		DefaultMenuItem about = new DefaultMenuItem("About Primefaces");
		// Create menuitem
		DefaultMenuItem contact = new DefaultMenuItem("Contact Us");
		// Create menuitem
		DefaultMenuItem helpMenuItem = new DefaultMenuItem("Help");		
		
		// Determine menuitem action
		open.setCommand("#{menuManagedBean.openAction}");
		
		// Associate menuitem with submenu
		file.addElement(open);
		file.addElement(edit);
		file.addElement(new DefaultSeparator());
		file.addElement(exit);
		
		help.addElement(about);
		help.addElement(contact);
		help.addElement(new DefaultSeparator());
		help.addElement(helpMenuItem);
		
		// Associate submenu with menu
		menu.addElement(file);
		menu.addElement(help);
	}
	
	public MenuModel getMenu() {
		return menu;
	}

	public void setMenu(MenuModel menu) {
		this.menu = menu;
	}

	public String openAction(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Open action has activiated asynchrounsly !"));
		return "";
	}
}
