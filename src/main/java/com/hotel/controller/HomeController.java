package com.hotel.controller;


import com.hotel.Service.Collector.CollectorDashboardService;
import com.hotel.Service.LoginVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    LoginVerificationService loginVerificationService;
    @Autowired
    ManageTranscation manageTranscation;
    @Autowired
    CollectorDashboardService collectorDashboardService;
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

        if(loginVerificationService.verifyAtLogin(role,userId,passwd)){
            if(role.equals("Manager"))
            {
                totalAmount=manageTranscation.fetchTotalAmount(userId);
                model.addAttribute("hotelId",userId);
                model.addAttribute("totalAmount",totalAmount);
                return "managerDashboard";
            }
            else if(role.equals("Collector")){
                totalAmount= collectorDashboardService.fetchAmount(userId);
                model.addAttribute("collectorId",userId);
                model.addAttribute("totalAmount",totalAmount);
                return "collectorDashboardService";}
            else{
                model.addAttribute("approverId",userId);
                return "approverDashboard";}
        }
        else{
            model.addAttribute("invalid","Invalid Credentials");
            return "newLogin";
        }
    }


}