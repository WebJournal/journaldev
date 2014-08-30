package com.journaldev.web.converter;
import com.journaldev.jpa.data.Employee;
import org.springframework.roo.addon.jsf.converter.RooJsfConverter;

@RooJsfConverter(entity = Employee.class)
public class EmployeeConverter {
}
