package com.journaldev.validator.hibernate.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AnotherBean {

	@NotNull
	@Valid
	private MyChildBean childBean;

	public MyChildBean getChildBean() {
		return childBean;
	}

	public void setChildBean(MyChildBean childBean) {
		this.childBean = childBean;
	}
}
