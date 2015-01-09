package com.journaldev.jsf.beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Login {
    
    private String uname;
     private String password;
     
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public String UservalidOrnot() { 
        
       if(uname.equals("adam") && password.equals("adam")) {
           return "success";
       }  else {
           return "failure";
       }
    }
    
}

