package com.hotel.bean;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeFunctions {
    List<User> list=new ArrayList<>();

    public void addemployee(User user){
        list.add(user);
    }

}
