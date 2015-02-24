
package com.journaldev.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean
@RequestScoped
public class Welcome {
 
    private String w1 = "Welcome!!!";

    public String getW1() {
        return w1;
    }

    public void setW1(String w1) {
        this.w1 = w1;
    }
 
    
}
