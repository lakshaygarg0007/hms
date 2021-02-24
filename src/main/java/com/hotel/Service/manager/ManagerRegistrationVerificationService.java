package com.hotel.Service.manager;

import com.hotel.Repository.*;
import com.hotel.bean.collector.CollectorCollection;
import com.hotel.bean.collector.CollectorEntity;
import com.hotel.bean.collector.collectorHotel;
import com.hotel.bean.manager.ManagerEntity;
import com.hotel.bean.manager.ManagerExpense;
import com.hotel.bean.manager.ManagerTransaction;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class ManagerRegistrationVerificationService {

    @Autowired
    ManagerRegistrationRepository managerRegistrationRepository;
    @Autowired
    CollectorManagerRepository collectorManagerRepository;
    @Autowired
    CollectorRegistrationRepository collectorRegistrationRepository;
    @Autowired
    ManagerTransactionRepository managerTransactionRepository;
    @Autowired
    ManagerExpenseRepository managerExpenseRepository;
    @Autowired
    CollectorCollectionsRepository collectorCollectionsRepository;

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
            //Here collector is also assigned

            ManagerEntity managerEntity = new ManagerEntity(map.get("hotelId"), map.get("fname"), map.get("lname"), map.get("email"),map.get("cnumber") ,map.get("passwd"));
            managerRegistrationRepository.save(managerEntity);
            String hotelId=map.get("hotelId");

            List<CollectorEntity> list=collectorRegistrationRepository.findAll();
            List<Pair<String , Integer>> pq=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                String collectorId=list.get(i).getCollectorId();
                System.out.println(collectorId);
                int hotelsAssigned=collectorManagerRepository.findByCollectorID(collectorId).size();
                System.out.println(hotelsAssigned);
                pq.add(new Pair<>(collectorId,hotelsAssigned));
            }
            Collections.sort(pq, Comparator.comparing(p -> -p.getValue()));
            Double cashAvailable=0.0;
            List<ManagerTransaction> managerTransactionRepositories=managerTransactionRepository.findByHotelId(hotelId);
            List<ManagerExpense> managerExpenses=managerExpenseRepository.findByHotelId(hotelId);
            for(int i=0;i<managerTransactionRepositories.size();i++){
                cashAvailable+=managerTransactionRepositories.get(i).getTransaction();
            }
            for(int i=0;i<managerExpenses.size();i++){
                cashAvailable-= managerExpenses.get(i).getExpense();
            }

            collectorHotel obj = new collectorHotel(pq.get(pq.size()-1).getKey(), hotelId);

            collectorManagerRepository.save(obj);
            return new Pair<>("Registered Successfully You can Login",true);
        }

    }
}
