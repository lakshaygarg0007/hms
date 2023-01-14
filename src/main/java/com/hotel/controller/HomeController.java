package com.hotel.controller;


import com.hotel.Service.Collector.CollectorDashboardService;
import com.hotel.Service.LoginVerificationService;
import com.hotel.Service.manager.ManagerDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class HomeController {
    @Autowired
    LoginVerificationService loginVerificationService;
    @Autowired
    ManagerDashboardService managerDashboardService;
    @Autowired
    CollectorDashboardService collectorDashboardService;
    Double totalAmount=0.0;
    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/")
    public String index(Model model) {
        String userId = String.valueOf(session.getAttribute("userId"));
        if(!("null").equals(userId)) {
            String role = String.valueOf(session.getAttribute("role"));
            if(role.equals("Manager"))
            {
                totalAmount=managerDashboardService.fetchTotalAmount(userId);
                model.addAttribute("hotelId",userId);
                model.addAttribute("totalAmount",totalAmount);
                return "manager/managerDashboard";
            }
            else if(role.equals("Collector")){
                totalAmount= collectorDashboardService.fetchAmount(userId);
                model.addAttribute("collectorId",userId);
                model.addAttribute("totalAmount",totalAmount);
                return "collector/collectorDashboard";}
            else{
                model.addAttribute("approverId",userId);
                return "approver/approverDashboard";}
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/newRegistration")
    public String newRegistraion(){
        return "newRegistration";
    }

    @RequestMapping(value = "/newLogin")
    public String login(){
        return "newLogin";
    }


    @RequestMapping(value = "/LoginVerification",method = RequestMethod.POST)
    public String verify(@RequestParam(value = "role")String role, @RequestParam(value = "userId")String userId, @RequestParam(value = "passwd")String passwd, Model model) {
        if(loginVerificationService.verifyAtLogin(role,userId,passwd)){
            session.setAttribute("userId", userId);
            session.setAttribute("role", role);
            if(role.equals("Manager"))
            {
                totalAmount=managerDashboardService.fetchTotalAmount(userId);
                model.addAttribute("hotelId",userId);
                model.addAttribute("totalAmount",totalAmount);
               // session.setAttribute("totalAmount", totalAmount);
                return "manager/managerDashboard";
            }
            else if(role.equals("Collector")){
                totalAmount= collectorDashboardService.fetchAmount(userId);
                model.addAttribute("collectorId",userId);
                model.addAttribute("totalAmount",totalAmount);
              //  session.setAttribute("totalAmount", totalAmount);
                return "collector/collectorDashboard";}
            else{
                model.addAttribute("approverId",userId);
                return "approver/approverDashboard";}
        }
        else{
            model.addAttribute("invalid","Invalid Credentials");
            return "newLogin";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        session.invalidate();
        return "newLogin";
    }



}