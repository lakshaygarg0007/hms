package com.hotel.controller.manager;

import com.hotel.Service.manager.ManageTranscation;
import com.hotel.Service.LoginVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

import static com.sun.tools.javac.util.Constants.format;

@Controller
public class ManagerController {

    @Autowired
    LoginVerification loginVerification;
    @Autowired
    ManageTranscation manageTranscation;




    @RequestMapping(value = "/managerRegistration")
    public String managerRegistration(){
        return "managerRegistration";
    }



}
