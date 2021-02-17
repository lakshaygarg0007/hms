package com.hotel.controller.manager;

import com.hotel.Service.manager.ManageTranscation;
import com.hotel.Service.manager.ManagerLoginVerification;
import com.hotel.bean.manager.ManagerTranscation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ManagerDashboardControls {
    @Autowired
    ManageTranscation manageTranscation;
    @Autowired
    ManagerLoginVerification managerLoginVerification;

    @RequestMapping(value = "/addTransaction",method = RequestMethod.POST)
    public void addTranscation(@RequestParam(value = "hotelId")String hotelId,@RequestParam(value = "newamount") Double newamount,@RequestParam(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        manageTranscation.addTranscation(hotelId, newamount, date);
    }

    @RequestMapping(value = "/viewTransaction",method=RequestMethod.POST)
    public Double fetchTranscation(@RequestParam(value="hotelId") String hotelId,@RequestParam(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return manageTranscation.fetchTranscation(hotelId,date);
    }

    @RequestMapping(value="/transactionHistory",method = RequestMethod.POST)
    public List<ManagerTranscation> transcationHistory(@RequestParam(value = "startingDate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date startingDate, @RequestParam(value = "endingDate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date endingDate)
    {
       return manageTranscation.transactionHistory(startingDate,endingDate);
    }

}
