package com.journaldev.jsf.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class Mobile implements Serializable {

	private static final long serialVersionUID = -7250065889869767422L;

	// @NotNull(message="Please enter the model number")
	private String mno;

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public void validateModelNo(FacesContext context, UIComponent comp,
			Object value) {

		System.out.println("inside validate method");

		String mno = (String) value;

		if (mno.length() < 4) {
			((UIInput) comp).setValid(false);

			FacesMessage message = new FacesMessage(
					"Minimum length of model number is 4");
			context.addMessage(comp.getClientId(context), message);

		}

	}

}
