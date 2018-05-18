package com.journaldev.spring.autowiring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.autowiring.service.EmployeeAutowiredByConstructorService;
import com.journaldev.spring.autowiring.service.EmployeeAutowiredByTypeService;
import com.journaldev.spring.autowiring.service.EmployeeService;

public class SpringMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		EmployeeService serviceByName = ctx.getBean("employeeServiceByName", EmployeeService.class);
		
		System.out.println("Autowiring byName. Employee Name="+serviceByName.getEmployee().getName());
		
		EmployeeService serviceByType = ctx.getBean("employeeServiceByType", EmployeeService.class);
		
		System.out.println("Autowiring byType. Employee Name="+serviceByType.getEmployee().getName());
		
		EmployeeService serviceByConstructor = ctx.getBean("employeeServiceConstructor", EmployeeService.class);
		
		System.out.println("Autowiring by Constructor. Employee Name="+serviceByConstructor.getEmployee().getName());
		
		//printing hashcode to confirm all the objects are of different type
		System.out.println(serviceByName.hashCode()+"::"+serviceByType.hashCode()+"::"+serviceByConstructor.hashCode());
		
		//Testing @Autowired annotations
		EmployeeAutowiredByTypeService autowiredByTypeService = ctx.getBean("employeeAutowiredByTypeService",EmployeeAutowiredByTypeService.class);
		
		System.out.println("@Autowired byType. Employee Name="+autowiredByTypeService.getEmployee().getName());

		EmployeeAutowiredByConstructorService autowiredByConstructorService = ctx.getBean("employeeAutowiredByConstructorService",EmployeeAutowiredByConstructorService.class);
		
		System.out.println("@Autowired by Constructor. Employee Name="+autowiredByConstructorService.getEmployee().getName());

		ctx.close();
	}

}
