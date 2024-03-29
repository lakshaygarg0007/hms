package com.hotel.controller.approver;

import com.hotel.Service.approver.ApproverRegistrationVerificationService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ApproverRegistrationController {
    @Autowired
    ApproverRegistrationVerificationService approverRegistrationVerificationService;

    @RequestMapping(value = "/approverRegistrationVerify",method = RequestMethod.POST)
    public String register(@RequestParam Map<String,String> map, Model model){
        Pair<String,Boolean> pair= approverRegistrationVerificationService.verify(map);
        if(pair.getValue()){
            model.addAttribute("success",pair.getKey());
            return "newLogin";
        }
        else{
            model.addAttribute("error",pair.getKey());
            return "approver/approverDashboard";
        }
    }

    @RequestMapping(value = "/approverRegistration", method = RequestMethod.GET)
    public String managerRegistration() {
        return "approver/approverRegistration";
    }

}
