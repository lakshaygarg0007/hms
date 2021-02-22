package com.hotel.Service.Collector;

import com.hotel.Repository.ApproverCollectorRepository;
import com.hotel.Repository.ApproverRegistrationRepository;
import com.hotel.Repository.CollectorRegistrationRepository;
import com.hotel.bean.approver.approverCollector;
import com.hotel.bean.approver.approverEntity;
import com.hotel.bean.collector.CollectorEntity;
import com.hotel.bean.collector.collectorHotel;
import com.hotel.bean.manager.ManagerEntity;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollectorRegistrationVerification {
    @Autowired
    CollectorRegistrationRepository collectorRegistrationRepository;
    @Autowired
    ApproverRegistrationRepository approverRegistrationRepository;
    @Autowired
    ApproverCollectorRepository approverCollectorRepository;

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
            CollectorEntity collectorEntity = new CollectorEntity(map.get("collectorId"), map.get("fname"), map.get("lname"), map.get("email"),map.get("cnumber") ,map.get("passwd"));
            collectorRegistrationRepository.save(collectorEntity);
            List<approverEntity> approverEntities=approverRegistrationRepository.findAll();
            List<Pair<String , Integer>> pq=new ArrayList<>();
            for(int i=0;i<approverEntities.size();i++){
            String approverId=approverEntities.get(i).getApproverId();
            System.out.println(approverId);
            int collectorsAssigned=approverCollectorRepository.findByApproverId(approverId).size();
            System.out.println(collectorsAssigned);
            pq.add(new Pair<>(approverId,collectorsAssigned));
        }
        Collections.sort(pq, Comparator.comparing(p -> -p.getValue()));
            approverCollector obj=new approverCollector(map.get("collectorId"),pq.get(pq.size()-1).getKey());
            approverCollectorRepository.save(obj);
            return new Pair<>("Registered Successfully You can Login",true);


    }
}
