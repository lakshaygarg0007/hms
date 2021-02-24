package com.hotel.Service.Collector;


import com.hotel.Repository.CollectorCollectionsRepository;
import com.hotel.Repository.CollectorHotelRepository;
import com.hotel.Repository.ManagerExpenseRepository;
import com.hotel.Repository.ManagerTransactionRepository;
import com.hotel.bean.collector.CollectorCollection;
import com.hotel.bean.collector.collectorHotel;
import com.hotel.bean.manager.ManagerExpense;
import com.hotel.bean.manager.ManagerTransaction;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CollectorDashboardService {
    @Autowired
    CollectorHotelRepository collectorHotelRepository;
    @Autowired
    ManagerTransactionRepository managerTransactionRepository;
    @Autowired
    ManagerExpenseRepository managerExpenseRepository;
    @Autowired
    CollectorCollectionsRepository collectorCollectionsRepository;
    public List<Pair<String,Double>> showHotels(String collectorId){
        List<Pair<String,Double>> myList=new ArrayList<>();
        List<collectorHotel> collectorHotels=collectorHotelRepository.findByCollectorID(collectorId);
        for(int i=0;i<collectorHotels.size();i++){
            String hotelId=collectorHotels.get(i).getHotelId();
            List<ManagerTransaction> hotelList=managerTransactionRepository.findByHotelId(hotelId);
            for(int j=0;j<hotelList.size();j++){
                if(hotelList.get(j).getCollectedCash()){
                    myList.add(new Pair<>(hotelId,hotelList.get(i).getTransaction()));
                }
            }
        }
        return myList;
    }

    public void collectCash(String hotelId,Double Amount){
        Date date = new Date();
        ManagerExpense managerExpense=new ManagerExpense(hotelId,Amount,date);
        managerExpenseRepository.save(managerExpense);
    }

    public Double fetchAmount(String collectorId){
        List<CollectorCollection> collectorCollections=collectorCollectionsRepository.findByCollectorId(collectorId);
        Double amount=0.0;
        for(int i=0;i<collectorCollections.size();i++){
            amount+=collectorCollections.get(i).getAmount();
        }
        return amount;
    }


}
