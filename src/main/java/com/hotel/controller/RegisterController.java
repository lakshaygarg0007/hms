package com.hotel.controller;

import com.hotel.Repository.DBRepository;
import com.hotel.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    DBRepository dbsave;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam Map<String,String> map, Model model){
        String cnumber=map.get("cnumber");
        String uname=map.get("uname");
        System.out.println(cnumber.length());
       // if(cnumber.length()==10)
  //       model.addAttribute("cnumber",cnumber);
        //model.
        User obj=new User(map.get("uname"),map.get("fname"),map.get("lname"),map.get("cnumber"),map.get("email"),map.get("passwd"));
        System.out.println(map.get("uname")+map.get("fname")+map.get("lname")+ map.get("cnumber")+map.get("email")+map.get("passwd"));
         dbsave.save(obj);
        /*model.addAllAttributes(map);*/

        /*if(role.equals("manager")){
            dbsave.save()
        }
        else if(role.equals("collector")){

        }
        else if(role.equals("approver")){

        }*/
        return "dashboard";
    }

    
}
