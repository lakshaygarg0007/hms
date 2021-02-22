package com.hotel.controller.collector;

import com.hotel.Service.Collector.CollectorRegistrationVerification;
import com.hotel.Service.manager.ManagerRegistrationVerification;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CollectorRegistrationController {
    @Autowired
    CollectorRegistrationVerification collectorRegistrationVerification;
    @RequestMapping(value = "/collectorRegistrationVerify",method = RequestMethod.POST)
    public String register(@RequestParam Map<String,String> map, Model model){
        Pair<String,Boolean> pair= collectorRegistrationVerification.verify(map);
        if(pair.getValue()){
            model.addAttribute("success",pair.getKey());
            return "newLogin";
        }
        else{
            model.addAttribute("error",pair.getKey());
            return "collectorRegistration";
        }
    }
}
