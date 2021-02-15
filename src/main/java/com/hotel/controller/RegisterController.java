package com.hotel.controller;

import com.hotel.Repository.DBRepository;
import com.hotel.bean.Manager;
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
        //Check if mobile number is 10 length and username is not taken
         if(cnumber.length()==10 && !dbsave.existsById(uname))
         {
               model.addAttribute("success", "Registered Successfully ");
               Manager obj = new Manager(map.get("uname"), map.get("fname"), map.get("lname"), map.get("cnumber"), map.get("email"), map.get("passwd"));
               dbsave.save(obj);
         }
        else if(cnumber.length()!=10){
             model.addAttribute("cnumbererror","Wrong Contact Number");
         }
         else{
             model.addAttribute("unameerror","Username already taken");
         }


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
