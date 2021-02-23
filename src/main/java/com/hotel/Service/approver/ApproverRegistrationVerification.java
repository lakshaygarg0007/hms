package com.hotel.Service.approver;

import com.hotel.Repository.ApproverRegistrationRepository;
import com.hotel.Repository.CollectorRegistrationRepository;
import com.hotel.bean.approver.approverEntity;
import com.hotel.bean.collector.CollectorEntity;
import com.hotel.bean.collector.collectorHotel;
import com.hotel.bean.manager.ManagerEntity;
import com.hotel.controller.approver.ApproverRegistration;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApproverRegistrationVerification {
    @Autowired
    ApproverRegistrationRepository approverRegistrationRepository;

    public Pair<String,Boolean> verify(Map<String,String> map)
    {
      /*  String cnumber = map.get("cnumber");
        String uname = map.get("collectorId");
        //Check if mobile number is 10 length and username is not taken
        if(! map.get("passwd").equals(map.get("retypePasswd")))
        {
            System.out.println(map.get("passwd")+"  "+map.get("retypePasswd"));
            return new Pair<>("Password Does Not Match",false);
        }
        else if (cnumber.length() != 10)
        {
            return  new Pair<>("Wrong Contact Number",false);
        }
        else if(collectorRegistrationRepository.existsById(uname))
        {
            return new Pair<>("Username already taken", false);
        }
        else
        {*/
        System.out.println("im here lalal");
        approverEntity approverEntity = new approverEntity(map.get("approverId"), map.get("fname"), map.get("lname"), map.get("email"),map.get("cnumber") ,map.get("passwd"));
        approverRegistrationRepository.save(approverEntity);
        return new Pair<>("Registered Successfully You can Login",true);

    }
}
