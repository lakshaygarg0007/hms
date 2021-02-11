package com.hotel.controller;


import com.hotel.bean.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String sendForm() {
        return "index";
    }

    @RequestMapping("/dashboard")
    public String fetchdashboard(@RequestParam(value = "data") String s, Model model){
        model.addAttribute("key",s);
        return "dashboard";
    }

}