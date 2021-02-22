package com.hotel.controller;


import com.hotel.Service.LoginVerification;
import com.hotel.Service.manager.ManageTranscation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
public class HomeController {
    @Autowired
    LoginVerification loginVerification;
    @Autowired
    ManageTranscation manageTranscation;
    Double totalAmount=0.0;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/newRegistration")
    public String newRegistraion(){
        return "newRegistration";
    }

    @RequestMapping(value = "/newLogin")
    public String login(){
        return "newLogin";
    }
    
    @RequestMapping("/managerLogin")
    public String managerLogin(){
        return "managerLogin";
    }

    @RequestMapping(value = "/LoginVerification",method = RequestMethod.POST)
    public String verify(@RequestParam(value = "role")String role, @RequestParam(value = "userId")String userId, @RequestParam(value = "passwd")String passwd, Model model) {
        //System.out.println(role+" "+userId+" "+passwd);

        if(loginVerification.verifyAtLogin(role,userId,passwd)){
            if(role.equals("Manager"))
            {
                totalAmount=manageTranscation.fetchTotalAmount(userId);
                model.addAttribute("hotelId",userId);
                model.addAttribute("totalAmount",totalAmount);
                return "managerDashboard";
            }
            else if(role.equals("Collector")){
                model.addAttribute("collectorId",userId);
                return "collectorDashboard";}
            else{
                model.addAttribute("approverId",userId);
                return "approverDashboard";}
        }
        else{
            model.addAttribute("invalid","Invalid Credentials");
            return "newLogin";
        }
    }

   /* @RequestMapping(value = "/dashboard",method = RequestMethod.POST)
    public String  fetchdashboard(@RequestParam(value = "uname") String uname, @RequestParam(value = "passwd")String passwd, Model model){
     User user=new User(uname,passwd);
        obj.save(user);
        model.addAttribute("user",user);
        return "dashboard";
    }*/

 /*   @RequestMapping(value = "/demo",method = RequestMethod.POST)
    public String demo(@RequestParam(value="role") String s,Model model){
        model.addAttribute("printthis",s);
        System.out.println(s);
        if(s.equals("manager")){
            return "mngr-dashboard";
        }
        else
        return "demo";
    }
*/

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