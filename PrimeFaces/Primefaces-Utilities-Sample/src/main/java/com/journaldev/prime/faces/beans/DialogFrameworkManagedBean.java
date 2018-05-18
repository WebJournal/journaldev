package com.journaldev.prime.faces.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


@ManagedBean
@SessionScoped
public class DialogFrameworkManagedBean {
	private List<Employee> employees = new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String showDialog(){
		RequestContext.getCurrentInstance().openDialog("externalXHTML");
		return "";
	}
	
	public String showDialogWithAdditionalArg(){
		// Fill in properties
		Map<String,Object> properties  = new HashMap<String,Object>();
		properties.put("modal", true);
		properties.put("resizable", true);
		properties.put("draggable", true);
		properties.put("width", 400);
		properties.put("height", 400);
		RequestContext.getCurrentInstance().openDialog("externalXHTML",properties,null);
		return "";
	}
	
	public String showEmployeesDialog(){
		this.employees = new ArrayList<Employee>();
		for(int i = 1 ; i < 10 ; i++){
			Employee employee = new Employee();
			employee.setEmployeeId(i);
			employee.setEmployeeName("Employee"+i);
			employee.setEmployeeAge(String.valueOf(21+i));
			this.employees.add(employee);
		}
		RequestContext.getCurrentInstance().openDialog("employees");
		return "";
	}
	
	public void selectEmployeeFromDialog(Employee employee) {
        RequestContext.getCurrentInstance().closeDialog(employee);
    }
	
	public void onEmployeeChosen(SelectEvent event){
		Employee employee = (Employee) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Employee Selected", 
        		"Id:" + employee.getEmployeeId()+"\n"+
        		"Name:"+employee.getEmployeeName());
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String showMessage(){
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Message Is Shown"));
		return "";
	}
	
	public class Employee {
		private int employeeId;
		private String employeeName;
		private String employeeAge;
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getEmployeeAge() {
			return employeeAge;
		}
		public void setEmployeeAge(String employeeAge) {
			this.employeeAge = employeeAge;
		}
	}
	
}
