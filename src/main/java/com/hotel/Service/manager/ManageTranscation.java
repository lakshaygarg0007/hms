package com.hotel.Service.manager;

import com.hotel.Repository.ManagerTranscationRepository;
import com.hotel.bean.manager.ManagerTranscation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManageTranscation {
    @Autowired
    ManagerTranscationRepository managertranscationdb;
    ManagerTranscation managerDashboard=new ManagerTranscation();
    public void addTranscation(String hotelId, Double newAmount, Date date){
        ManagerTranscation newtranscation=new ManagerTranscation(hotelId,newAmount,date);
        managertranscationdb.save(newtranscation);
    }

    public Double fetchTranscation(String hotelId,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
      // managertranscationdb
        List<ManagerTranscation> list=managertranscationdb.findByHotelIdAndDate(hotelId, date);
        return list.get(0).getNewamount();
    }

    public List<ManagerTranscation> transactionHistory(Date startingDate, Date endingDate){
        return managertranscationdb.findByDateBetween(startingDate, endingDate);
    }
}
