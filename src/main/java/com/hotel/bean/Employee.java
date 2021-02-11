package com.hotel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Employee{

    @Id
    private String fname;
    @Column
    private String lname;

    public String getFname() {
        return fname;
    }

    public Employee(){

    }


    public Employee(String fname,String lname){
        this.fname=fname;
        this.lname=lname;
    }


    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}