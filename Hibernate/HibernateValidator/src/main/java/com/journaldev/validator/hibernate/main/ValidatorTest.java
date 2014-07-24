package com.journaldev.validator.hibernate.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.hibernate.validator.HibernateValidator;

import com.journaldev.validator.hibernate.model.AnotherBean;
import com.journaldev.validator.hibernate.model.EmpIdCheck;
import com.journaldev.validator.hibernate.model.Employee;
import com.journaldev.validator.hibernate.model.EmployeeXMLValidation;
import com.journaldev.validator.hibernate.model.MyChildBean;
import com.journaldev.validator.hibernate.model.ParamValidationBean;

public class ValidatorTest {

	public static void main(String[] args) throws FileNotFoundException, NoSuchMethodException, SecurityException {
		
		//Getting Validator instance with Annotations
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		//If there are multiple JSR303 implementations in classpath
		//we can get HibernateValidator specifically too
		ValidatorFactory hibernateVF = Validation.byProvider(HibernateValidator.class)
									.configure().buildValidatorFactory();
		
		System.out.println("\nSimple field level validation example");
		Employee emp = new Employee(-1, "Name","email","123");
		Set<ConstraintViolation<Employee>> validationErrors = validator.validate(emp);
		
		if(!validationErrors.isEmpty()){
			for(ConstraintViolation<Employee> error : validationErrors){
				System.out.println(error.getMessageTemplate()+"::"+error.getPropertyPath()+"::"+error.getMessage());
				
			}
		}
		
		System.out.println("\nXML Based validation example");
		
		//XML Based validation
		Configuration<?> config = Validation.byDefaultProvider().configure();
		config.addMapping(new FileInputStream("employeeXMLValidation.xml"));
		ValidatorFactory validatorFactory1 = config.buildValidatorFactory();
		Validator validator1 = validatorFactory1.getValidator();
		
		EmployeeXMLValidation emp1 = new EmployeeXMLValidation(10, "Name","email","123");
		
		Set<ConstraintViolation<EmployeeXMLValidation>> validationErrors1 = validator1.validate(emp1);
		
		if(!validationErrors1.isEmpty()){
			for(ConstraintViolation<EmployeeXMLValidation> error : validationErrors1){
				System.out.println(error.getMessageTemplate()+"::"+error.getInvalidValue()+"::"+ error.getPropertyPath()+"::"+error.getMessage());
				
			}
		}
		
		System.out.println("\nValidation Group example");
		validationErrors = validator.validate(emp, EmpIdCheck.class);
		
		if(!validationErrors.isEmpty()){
			for(ConstraintViolation<Employee> error : validationErrors){
				System.out.println(error.getMessageTemplate()+"::"+error.getPropertyPath()+"::"+error.getMessage());
				
			}
		}
		
		System.out.println("\nValidation with inheritance example");

		//Validation inheritance and Property-level constraints example
		MyChildBean childBean = new MyChildBean();
		Set<ConstraintViolation<MyChildBean>> validationInheritanceErrors = validator.validate(childBean);
		
		if(!validationInheritanceErrors.isEmpty()){
			for(ConstraintViolation<MyChildBean> error : validationInheritanceErrors){
				System.out.println(error.getMessageTemplate()+"::"+error.getPropertyPath()+"::"+error.getMessage());
				
			}
		}
		
		System.out.println("\nValidation in composition using @Valid annotation");

		//@Valid annotation - validation in composition example
		AnotherBean compositionBean = new AnotherBean();
		compositionBean.setChildBean(new MyChildBean());
		Set<ConstraintViolation<AnotherBean>> validationCompositionErrors = validator.validate(compositionBean);
		
		if(!validationCompositionErrors.isEmpty()){
			for(ConstraintViolation<AnotherBean> error : validationCompositionErrors){
				System.out.println(error.getMessageTemplate()+"::"+error.getPropertyPath()+"::"+error.getMessage());
				
			}
		}
		
		System.out.println("\nParameter validation example");
		ParamValidationBean paramValidationBean = new ParamValidationBean("Pankaj");
		Method method = ParamValidationBean.class.getMethod("printData", String.class);
		Object[] params = {"1234"};
		ExecutableValidator executableValidator = validator.forExecutables();
		Set<ConstraintViolation<ParamValidationBean>> violations = 
				executableValidator.validateParameters(paramValidationBean, method, params);
		if(!violations.isEmpty()){
			for(ConstraintViolation<ParamValidationBean> error : violations){
				System.out.println(error.getMessageTemplate()+"::"+error.getPropertyPath()+"::"+error.getMessage());
				
			}
		}
		
	}

}
