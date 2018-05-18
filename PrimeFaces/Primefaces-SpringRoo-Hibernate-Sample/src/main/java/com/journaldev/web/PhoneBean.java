package com.journaldev.web;
import com.journaldev.jpa.data.Phone;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Phone.class, beanName = "phoneBean")
public class PhoneBean {
}
