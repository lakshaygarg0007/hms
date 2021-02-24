package com.hotel.controller.manager;

import com.hotel.Service.manager.ManagerRegistrationVerificationService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ManagerRegisterController {
    @Autowired
    ManagerRegistrationVerificationService managerRegistrationVerificationService;
    @RequestMapping(value = "/managerRegistrationVerify",method = RequestMethod.POST)
    public String register(@RequestParam Map<String,String> map, Model model){
        Pair<String,Boolean> pair= managerRegistrationVerificationService.verify(map);
        if(pair.getValue()){
            model.addAttribute("success",pair.getKey());
            return "newLogin";
        }
        else{
            model.addAttribute("error",pair.getKey());
            return "managerRegistration";
        }
    }
    
}
