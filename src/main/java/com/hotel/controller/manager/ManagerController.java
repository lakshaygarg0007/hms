package com.hotel.controller.manager;

import com.hotel.Repository.ManagerRegistrationRepository;
import com.hotel.Service.manager.ManageTranscation;
import com.hotel.Service.manager.ManagerLoginVerification;
import com.hotel.Service.manager.ManagerRegistrationVerification;
import com.zaxxer.hikari.util.SuspendResumeLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.tools.javac.util.Constants.format;

@Controller
public class ManagerController {

    @Autowired
    ManagerLoginVerification managerLoginVerification;
    @Autowired
    ManageTranscation manageTranscation;


    @RequestMapping(value = "/managerDashboard",method = RequestMethod.GET)
    public String myHomePage(){
        return "managerDashboard";
    }

    @RequestMapping(value = "/managerRegistration")
    public String managerRegistration(){
        return "managerRegistration";
    }

    @RequestMapping(value = "/managerLoginVerification",method = RequestMethod.POST)
    public String verify(@RequestParam(value = "hotelId")String hotelId, @RequestParam(value = "passwd")String passwd, Model model) throws ParseException {
        System.out.println(hotelId+" "+passwd);
        if(managerLoginVerification.verifyAtLogin(hotelId,passwd)){
            return "managerDashboard";
        }
        else{
            model.addAttribute("invalid","Invalid Credentials");
            return "login";}
    }

}
