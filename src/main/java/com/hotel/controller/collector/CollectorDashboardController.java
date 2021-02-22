package com.hotel.controller.collector;


import com.hotel.Repository.ApproverCollectorRepository;
import com.hotel.Repository.ApproverRequestsRepository;
import com.hotel.Repository.CollectorCollectionsRepository;
import com.hotel.Repository.CollectorManagerRepository;
import com.hotel.Service.Collector.CollectorDashboard;
import com.hotel.bean.approver.approverRequests;
import com.hotel.bean.collector.CollectorCollection;
import com.hotel.bean.collector.collectorHotel;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CollectorDashboardController {

    @Autowired
    CollectorDashboard collectorDashboard;
    @Autowired
    CollectorManagerRepository collectorManagerRepository;
    @Autowired
    ApproverRequestsRepository approverRequestsRepository;
    @Autowired
    CollectorCollectionsRepository collectorCollectionsRepository;
    @Autowired
    ApproverCollectorRepository approverCollectorRepository;
    @Autowired
    CollectorDashboard collectorDashboardService;


    @RequestMapping(value = "/showHotels",method = RequestMethod.POST)
    public String showHotels(@RequestParam(value = "collectorId") String collectorId, Model model){
        List<collectorHotel> collectorHotels=collectorManagerRepository.findByCollectorID(collectorId);
        Double amount=collectorDashboardService.fetchAmount(collectorId);
        model.addAttribute("totalAmount",amount);
        System.out.println(collectorHotels.size());
        System.out.println(collectorHotels.get(0).getHotelId());
        model.addAttribute("collectorId",collectorId);
        model.addAttribute("list",collectorHotels);
        model.addAttribute("c1","Hotels ");
        model.addAttribute("c2","cashAvailable");
        model.addAttribute("c3","cashCollected");
        return "collectorDashboard";
    }

    @RequestMapping(value = "/collectCash",method = RequestMethod.POST)
    public String collectCash(@RequestParam(value = "hotelId")String hotelId,@RequestParam(value = "collectorId")String collectorId,@RequestParam(value = "amount")Double amount,Model model){
        Double tamount=collectorDashboardService.fetchAmount(collectorId);
        model.addAttribute("totalAmount",tamount);
        String approverId=approverCollectorRepository.findByCollectorId(collectorId).get(0).getApproverId();
        CollectorCollection collectorCollection=new CollectorCollection(hotelId,collectorId,approverId,amount,false);
        collectorCollectionsRepository.save(collectorCollection);
        return "collectorDashboard";
    }



}
