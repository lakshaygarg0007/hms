package com.hotel.bean;

import javafx.scene.control.PasswordField;
import sun.security.util.Password;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User{

    @Id
    private String uname;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private String email;
    @Column
    private int cnumbr;
    @Column
    private String passwd;

    public String getUname() {
        return uname;
    }

    public User(){

    }


    public User(String uname,String passwd){
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