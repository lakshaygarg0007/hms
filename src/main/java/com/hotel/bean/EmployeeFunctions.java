package com.hotel.bean;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeFunctions {
    List<Employee> list=new ArrayList<>();

    public void addemployee(Employee emp){
        list.add(emp);
    }

}
