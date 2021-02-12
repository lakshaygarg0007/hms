package com.hotel.bean;

import javafx.scene.control.PasswordField;
import sun.security.util.Password;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Employee{

    @Id
    private String uname;
    @Column
    private String passwd;

    public String getUname() {
        return uname;
    }

    public Employee(){

    }


    public Employee(String uname,String passwd){
        this.uname=uname;
        this.passwd=passwd;
    }


    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}