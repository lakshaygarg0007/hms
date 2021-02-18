package com.hotel.Service.manager;

import com.hotel.Repository.ManagerRegistrationRepository;
import com.hotel.bean.manager.ManagerEntity;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service

public class ManagerRegistrationVerification {

    @Autowired
    ManagerRegistrationRepository managerRegistrationRepository;

    public Pair<String,Boolean> verify(Map<String,String> map)
    {
        String cnumber = map.get("cnumber");
        String uname = map.get("hotelId");
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
        else if(managerRegistrationRepository.existsById(uname))
        {
            return new Pair<>("Username already taken", false);
        }
        else
        {
            ManagerEntity managerEntity = new ManagerEntity(map.get("hotelId"), map.get("fname"), map.get("lname"), map.get("email"),map.get("cname") ,map.get("passwd"));
            managerRegistrationRepository.save(managerEntity);
            return new Pair<>("Registered Successfully You can Login",true);
        }

    }
}
