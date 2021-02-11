package com.hotel.controller;


import com.hotel.Repository.DBRepository;
import com.hotel.bean.Employee;
import com.hotel.bean.EmployeeFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    DBRepository obj;

    @RequestMapping(value = "/")
    public String sendForm() {
        return "index";
    }


    @RequestMapping("/dashboard")
    public String fetchdashboard(@RequestParam(value = "fname") String fname,@RequestParam(value = "lname")String lname ,Model model){
        Employee emp=new Employee(fname,lname);
        obj.save(emp);
        model.addAttribute("emp",emp);
        return "dashboard";
    }

   /* @RequestMapping("/verify")
    public String verify(@RequestParam(value="fname")String fname,@RequestParam(value="lname") String lname,Model model){
        Employee emp=new Employee(fname,lname);
        boolean b=obj.existsById(emp.getFname());
        model.addAttribute("value",b);
        return "check";
    }*/

}