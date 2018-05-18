package com.journaldev.struts2.actions;

public class User {

	private String name;
	private String password;
	private String bio;
	private boolean receiveUpdates;
	private String[] rolesSelect;
	private String roleCheckbox;
	private String[] rolesRadio;
	private String doubleSelectRole;
	private String doubleSelectExpertise;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public boolean isReceiveUpdates() {
		return receiveUpdates;
	}

	public void setReceiveUpdates(boolean receiveUpdates) {
		this.receiveUpdates = receiveUpdates;
	}

	public String[] getRolesSelect() {
		return rolesSelect;
	}

	public void setRolesSelect(String[] rolesSelect) {
		this.rolesSelect = rolesSelect;
	}

	public String getRoleCheckbox() {
		return roleCheckbox;
	}

	public void setRoleCheckbox(String roleCheckbox) {
		this.roleCheckbox = roleCheckbox;
	}

	public String[] getRolesRadio() {
		return rolesRadio;
	}

	public void setRolesRadio(String[] rolesRadio) {
		this.rolesRadio = rolesRadio;
	}

	public String getDoubleSelectExpertise() {
		return doubleSelectExpertise;
	}

	public void setDoubleSelectExpertise(String doubleSelectExpertise) {
		this.doubleSelectExpertise = doubleSelectExpertise;
	}

	public String getDoubleSelectRole() {
		return doubleSelectRole;
	}

	public void setDoubleSelectRole(String doubleSelectRole) {
		this.doubleSelectRole = doubleSelectRole;
	}

}
