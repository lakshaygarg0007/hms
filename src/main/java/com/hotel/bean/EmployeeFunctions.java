package com.hotel.bean;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeFunctions {
    List<Manager> list=new ArrayList<>();

    public void addemployee(Manager user){
        list.add(user);
    }

}
