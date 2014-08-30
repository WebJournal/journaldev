package com.journaldev.jpa.data;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", sequenceName = "", table = "employee")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "phones" })
public class Employee {
}
