package com.hotel.controller.collector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CollectorRegistration {
    @RequestMapping(value = "/collectorRegistration")
    public String collectorRegistration(){
        return "collectorRegistration";
    }

}
