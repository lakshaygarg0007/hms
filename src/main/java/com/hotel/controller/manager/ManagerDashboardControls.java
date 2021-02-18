package com.hotel.controller.manager;

import com.hotel.Service.manager.ManageTranscation;
import com.hotel.Service.manager.ManagerLoginVerification;
import com.hotel.bean.manager.ManagerTranscation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
public class ManagerDashboardControls {
    @Autowired
    ManageTranscation manageTranscation;
    @Autowired
    ManagerLoginVerification managerLoginVerification;

    @RequestMapping(value = "/addTransaction",method = RequestMethod.POST)
    public String addTranscation(@RequestParam(value = "hotelId")String hotelId,@RequestParam(value = "newamount") Double newamount,@RequestParam(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        manageTranscation.addTranscation(hotelId, newamount, date);
        return "demo";
    }

    @RequestMapping(value = "/viewTransaction",method=RequestMethod.POST)
    public String fetchTranscation(@RequestParam(value="hotelId") String hotelId,@RequestParam(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date,Model model){
        Double amount=manageTranscation.fetchTranscation(hotelId,date);
        model.addAttribute("amount",amount);
        return "demo";
    }

    @RequestMapping(value="/transactionHistory",method = RequestMethod.POST)
    public String transcationHistory(@RequestParam(value = "startingDate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date startingDate, @RequestParam(value = "endingDate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date endingDate, Model model)
    {
        List<ManagerTranscation> list=manageTranscation.transactionHistory(startingDate,endingDate);
        model.addAttribute("list",list);
        System.out.println(list.size());
        return "demo";
    }

}
