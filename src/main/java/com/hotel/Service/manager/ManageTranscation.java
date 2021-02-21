package com.hotel.Service.manager;

import com.hotel.Repository.ManagerTransactionRepository;
import com.hotel.bean.manager.ManagerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManageTranscation {
    @Autowired
    ManagerTransactionRepository managertranscationdb;
    ManagerTransaction managerDashboard=new ManagerTransaction();
    public void addTranscation(String hotelId, Double transaction, Date date){
        ManagerTransaction newtranscation=new ManagerTransaction(hotelId,transaction,date);
        managertranscationdb.save(newtranscation);
    }

    public Double fetchTranscation(String hotelId,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
      // managertranscationdb
        List<ManagerTransaction> list=managertranscationdb.findByHotelIdAndDate(hotelId, date);
        return list.get(0).getTransaction();
    }

    public List<ManagerTransaction> transactionHistory(Date startingDate, Date endingDate){
        return managertranscationdb.findByDateBetween(startingDate, endingDate);
    }
}
