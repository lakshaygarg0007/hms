package com.hotel.Service.manager;

import com.hotel.Repository.ManagerExpenseRepository;
import com.hotel.Repository.ManagerTransactionRepository;
import com.hotel.bean.manager.ManagerExpense;
import com.hotel.bean.manager.ManagerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManageTranscation {
    @Autowired
    ManagerTransactionRepository managerTransactionRepository;

    @Autowired
    ManagerExpenseRepository managerExpenseRepository;


    ManagerTransaction managerDashboard=new ManagerTransaction();
    public void addTranscation(String hotelId, Double transaction, Date date){
        ManagerTransaction newtranscation=new ManagerTransaction(hotelId,transaction,date);
        managerTransactionRepository.save(newtranscation);
    }

    public Double fetchTranscation(String hotelId,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
      // managertranscationdb
        List<ManagerTransaction> list=managerTransactionRepository.findByHotelIdAndDate(hotelId, date);
        return list.get(0).getTransaction();
    }

    public List<ManagerTransaction> transactionHistory(String hotelId,Date startingDate, Date endingDate){
        return managerTransactionRepository.findByHotelIdAndDateBetween(hotelId,startingDate, endingDate);
    }

    public Double fetchTotalAmount(String hotelId){
        Double totolAmount=0.0;
        List<ManagerTransaction> manageTranscations=managerTransactionRepository.findByHotelId(hotelId);
        List<ManagerExpense> managerExpenses=managerExpenseRepository.findByHotelId(hotelId);
        for(int i=0;i<manageTranscations.size();i++){
            totolAmount+=manageTranscations.get(i).getTransaction();
        }
        for(int i=0;i<managerExpenses.size();i++){
            totolAmount-=managerExpenses.get(i).getExpense();
        }
        return totolAmount;
    }

}
