package com.hotel.controller.collector;


import com.hotel.Service.Collector.CollectorDashboard;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CollectorDashboardController {

    @Autowired
    CollectorDashboard collectorDashboard;
    
    @RequestMapping("/viewHotels")
    public List<Pair<String,Double>> viewHotels(String collectorId){
        return collectorDashboard.showHotels(collectorId);
    }

}
