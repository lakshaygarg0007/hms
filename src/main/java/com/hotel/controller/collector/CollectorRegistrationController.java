package com.hotel.controller.collector;

import com.hotel.Service.Collector.CollectorRegistrationVerificationService;
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
    CollectorRegistrationVerificationService collectorRegistrationVerificationService;
    @RequestMapping(value = "/collectorRegistrationVerify",method = RequestMethod.POST)
    public String register(@RequestParam Map<String,String> map, Model model){
        Pair<String,Boolean> pair= collectorRegistrationVerificationService.verify(map);
        if(pair.getValue()){
            model.addAttribute("success",pair.getKey());
            return "newLogin";
        }
        else{
            model.addAttribute("error",pair.getKey());
            return "collector/collectorRegistration";
        }
    }

    @RequestMapping(value = "/collectorRegistration", method = RequestMethod.GET)
    public String managerRegistration() {
        return "collector/collectorRegistration";
    }
}
