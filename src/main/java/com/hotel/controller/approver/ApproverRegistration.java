package com.hotel.controller.approver;

import com.hotel.Repository.*;
import com.hotel.Service.approver.ApproverRegistrationVerification;
import com.hotel.Service.approver.ApproverDashboardService;
import com.hotel.Service.manager.ManagerRegistrationVerification;
import com.hotel.bean.approver.approverCollector;
import com.hotel.bean.approver.approverRequests;
import com.hotel.bean.collector.CollectorCollection;
import com.hotel.bean.collector.collectorHotel;
import com.hotel.bean.manager.ManagerExpense;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ApproverRegistration {
    @Autowired
    ApproverRegistrationVerification approverRegistrationVerification;
    @Autowired
    ApproverCollectorRepository approverCollectorRepository;
    @Autowired
    ApproverRequestsRepository approverRequestsRepository;
    @Autowired
    ManagerExpenseRepository managerExpenseRepository;
    @Autowired
    CollectorCollectionsRepository collectorCollectionsRepository;
    @Autowired
    CollectorHotelRepository collectorHotelRepository;


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


    @RequestMapping(value = "/showCollectors",method = RequestMethod.POST)
    public String showCollectors(@RequestParam(value = "approverId") String approverId, Model model){
        List<approverCollector> approverCollectors=approverCollectorRepository.findByApproverId(approverId);
    //    System.out.println(collectorHotels.size());
       // System.out.println(collectorHotel;
        model.addAttribute("approverId",approverId);
        model.addAttribute("collectors",approverCollectors);
        model.addAttribute("c1","Collectors");
        return "approverDashboard";
    }

    @Autowired
    ApproverDashboardService approverDashboardService;

    @RequestMapping(value = "/showRequests",method = RequestMethod.POST)
    public String showRequets(@RequestParam(value = "approverId")String approverId,Model model){
        List<CollectorCollection> list=approverDashboardService.showRequest("approverId");
        model.addAttribute("list",list);
        model.addAttribute("c1","Pending Requests");
        model.addAttribute("cId","Collector Id");
        model.addAttribute("amount","Amount");
        model.addAttribute("approverId",approverId);
        return "approverDashboard";
    }

    @RequestMapping(value = "/acceptRequest",method = RequestMethod.POST)
    public String acceptRequest(@RequestParam(value = "approverId") String approverId,@RequestParam(value = "serialNumber")int serialNumber,@RequestParam(value = "collectorId")String collectorId,@RequestParam(value = "amount")Double amount){
        String hotelId=collectorHotelRepository.findByCollectorID(collectorId).get(0).getHotelId();
        CollectorCollection collectorCollection=new CollectorCollection(serialNumber,hotelId,collectorId,approverId,amount,true);
        collectorCollectionsRepository.save(collectorCollection);
        return "approverDashboard";
    }



}
