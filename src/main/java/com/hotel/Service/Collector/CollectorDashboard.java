package com.hotel.Service.Collector;


import com.hotel.Repository.CollectorHotelRepository;
import com.hotel.Repository.ManagerTransactionRepository;
import com.hotel.bean.collector.collectorHotel;
import com.hotel.bean.manager.ManagerTransaction;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectorDashboard {
    @Autowired
    CollectorHotelRepository collectorHotelRepository;
    @Autowired
    ManagerTransactionRepository managerTransactionRepository;

    public List<Pair<String,Double>> showHotels(String collectorId){
        List<Pair<String,Double>> myList=new ArrayList<>();
        List<collectorHotel> collectorHotels=collectorHotelRepository.findByCollectorID(collectorId);
        for(int i=0;i<collectorHotels.size();i++){
            String hotelId=collectorHotels.get(i).getHotelId();
            List<ManagerTransaction> hotelList=managerTransactionRepository.findById(hotelId);
            for(int j=0;j<hotelList.size();j++){
                if(hotelList.get(j).getCollectedCash()){
                    myList.add(new Pair<>(hotelId,hotelList.get(i).getTransaction()));
                }
            }
        }
        return myList;
    }



}
