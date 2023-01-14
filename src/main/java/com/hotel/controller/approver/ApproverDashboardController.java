package com.hotel.controller.approver;

import com.hotel.Repository.*;
import com.hotel.Service.approver.ApproverDashboardService;
import com.hotel.Service.manager.ManagerDashboardService;
import com.hotel.bean.approver.approverCollector;
import com.hotel.bean.collector.CollectorCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ApproverDashboardController {

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
    @Autowired
    ManagerDashboardService managerDashboardService;

    @RequestMapping(value = "/showRequests",method = RequestMethod.POST)
    public String showRequets(@RequestParam(value = "approverId")String approverId,Model model){
        System.out.println(approverId+" heelo");
        List<CollectorCollection> list=approverDashboardService.showRequest(approverId);
        model.addAttribute("list",list);
        System.out.println("list size"+list.size());
        model.addAttribute("c1","Pending Requests");
        model.addAttribute("cId","Collector Id");
        model.addAttribute("serialNumber", "Serial Number");
        model.addAttribute("amount","Amount");
        model.addAttribute("approverId",approverId);
        return "approver/approverDashboard";
    }

    @RequestMapping(value = "/acceptRequest",method = RequestMethod.POST)
    public String acceptRequest(@RequestParam(value = "approverId") String approverId,@RequestParam(value = "serialNumber")int serialNumber,@RequestParam(value = "collectorId")String collectorId,@RequestParam(value = "amount")Double amount,Model model){
        String hotelId=collectorCollectionsRepository.findBySerialNumber(serialNumber).get(0).getHotelId();

        Double amountAvailable=managerDashboardService.fetchTotalAmount(hotelId);
       if(amountAvailable>=amount){
           model.addAttribute("success","Request Accepted Successfully");
           CollectorCollection collectorCollection=new CollectorCollection(serialNumber,hotelId,collectorId,approverId,amount,true);
           collectorCollectionsRepository.save(collectorCollection);
       }
       else{
           model.addAttribute("error","Not Enough Cash Available");
       }
        model.addAttribute("approverId",approverId);
        return "approverDashboard";
    }


}
