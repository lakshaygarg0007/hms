package com.hotel.controller;


import com.hotel.Repository.DBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

 /*   @Autowired
    DBRepository obj;
*/
    @RequestMapping(value = "/")
    public String sendForm() {
        return "Registration";
    }


   /* @RequestMapping(value = "/dashboard",method = RequestMethod.POST)
    public String  fetchdashboard(@RequestParam(value = "uname") String uname, @RequestParam(value = "passwd")String passwd, Model model){
     User user=new User(uname,passwd);
        obj.save(user);
        model.addAttribute("user",user);
        return "dashboard";
    }*/

    @RequestMapping(value = "/demo",method = RequestMethod.POST)
    public String demo(@RequestParam(value="role") String s,Model model){
        model.addAttribute("printthis",s);
        System.out.println(s);
        if(s.equals("manager")){
            return "mngr-dashboard";
        }
        else
        return "demo";
    }


    @RequestMapping("/verify")
    public String verify(){
        return "verify";
    }
/*
    @RequestMapping("/check")
    public String verify(@RequestParam(value="fname")String fname,@RequestParam(value="lname") String lname,Model model){
        boolean b=obj.existsById(fname);
        model.addAttribute("value",b);
        return "check";
    }*/

   /* @RequestMapping(value = "/payment",method = RequestMethod.POST)
    public String payment(@RequestParam(value = )){

    }
*/
}