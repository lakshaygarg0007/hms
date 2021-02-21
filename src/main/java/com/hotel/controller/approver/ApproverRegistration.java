package com.hotel.controller.approver;

import com.hotel.Service.Collector.ApproverRegistrationVerification;
import com.hotel.Service.manager.ManagerRegistrationVerification;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Map;

@Controller
public class ApproverRegistration {
    @Autowired
    ApproverRegistrationVerification approverRegistrationVerification;



    @RequestMapping(value = "/approverRegistration")
    public String collectorRegistration(){
        return "approverRegistration";
    }

    @RequestMapping(value = "/approverRegistrationVerify",method = RequestMethod.POST)
    public String register(@RequestParam Map<String,String> map, Model model){
        Pair<String,Boolean> pair= approverRegistrationVerification.verify(map);
        if(pair.getValue()){
            model.addAttribute("success",pair.getKey());
            return "newLogin";
        }
        else{
            model.addAttribute("error",pair.getKey());
            return "approverRegistration";
        }
    }





}
