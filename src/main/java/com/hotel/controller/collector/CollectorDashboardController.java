package com.hotel.controller.collector;


import com.hotel.Repository.CollectorManagerRepository;
import com.hotel.Service.Collector.CollectorDashboard;
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
    
    @RequestMapping("/collectorDashboard")
    public String collectorDashboard(){
        return "collectorDashboard";
    }

    @RequestMapping(value = "/showHotels",method = RequestMethod.POST)
    public String showHotels(@RequestParam(value = "collectorId") String collectorId, Model model){
        List<collectorHotel> collectorHotels=collectorManagerRepository.findByCollectorID(collectorId);
        System.out.println(collectorHotels.size());
        System.out.println(collectorHotels.get(0).getHotelId());
        model.addAttribute("list",collectorHotels);
        model.addAttribute("c1","Hotels ");
        model.addAttribute("c2","cashAvailable");
        model.addAttribute("c3","cashCollected");
        return "collectorDashboard";
    }



}
