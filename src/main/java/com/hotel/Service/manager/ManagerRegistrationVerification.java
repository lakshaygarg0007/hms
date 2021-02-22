package com.hotel.Service.manager;

import com.hotel.Repository.*;
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

public class ManagerRegistrationVerification {

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
            ManagerEntity managerEntity = new ManagerEntity(map.get("hotelId"), map.get("fname"), map.get("lname"), map.get("email"),map.get("cnumber") ,map.get("passwd"));
            managerRegistrationRepository.save(managerEntity);
            String hotelId=map.get("hotelId");
            /*Pair<Integer,String> pair=AtStarting.q.peek();
            collectorHotel collectorHotel=new collectorHotel(pair.getValue(),map.get("hotelId"));
            collectorManagerRepository.save(collectorHotel);
            */
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
                cashAvailable-=managerExpenses.get(i).getExpense();
            }
      //      List<Object[]> managerCollectorTable = collectorManagerRepository.findAllCollectors();
       //     String collectorId =managerCollectorTable.get(0)[1].toString();
      //      System.out.println(collectorId +"  "+managerCollectorTable.size()) ;

            collectorHotel obj = new collectorHotel(pq.get(pq.size()-1).getKey(), hotelId,cashAvailable,0.0);
//        PriorityQueue<Pair<Integer, String>> pq;
//        for(int i = 0 ; i < managerCollectorTable.size() ; i++){
//            pq.add(new Pair<Integer , String>(managerCollectorTable.get(i).getHotelId() , managerCollectorTable.get(i).getCollectorID()))
//        }
            collectorManagerRepository.save(obj);
            return new Pair<>("Registered Successfully You can Login",true);
        }

    }
}
