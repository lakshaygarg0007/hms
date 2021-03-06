package com.hotel.Service.manager;

import com.hotel.Repository.CollectorCollectionsRepository;
import com.hotel.Repository.ManagerExpenseRepository;
import com.hotel.Repository.ManagerTransactionRepository;
import com.hotel.bean.collector.CollectorCollection;
import com.hotel.bean.manager.ManagerExpense;
import com.hotel.bean.manager.ManagerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManagerDashboardService {
    @Autowired
    ManagerExpenseRepository managerExpenseRepository;
    @Autowired
    ManagerTransactionRepository managerTransactionRepository;

    @Autowired
    CollectorCollectionsRepository collectorCollectionsRepository;



    public void addExpense(String hotelId, Double transaction, Date date){
        ManagerExpense managerExpense=new ManagerExpense(hotelId,transaction,date);
        managerExpenseRepository.save(managerExpense);
    }

    public List<ManagerExpense> expenseHistory(String hotelId, Date startingDate, Date endingDate){
        return managerExpenseRepository.findByHotelIdAndDateBetween(hotelId,startingDate, endingDate);
    }


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
        List<CollectorCollection> collectorCollections=collectorCollectionsRepository.findByHotelId(hotelId);
        for(int i=0;i<manageTranscations.size();i++){
            totolAmount+=manageTranscations.get(i).getTransaction();
        }
        System.out.println(totolAmount);
        for(int i=0;i<managerExpenses.size();i++){
            totolAmount-=managerExpenses.get(i).getExpense();
        }
        System.out.println(totolAmount);
        for(int i=0;i<collectorCollections.size();i++){
            totolAmount-=collectorCollections.get(i).getAmount();
        }
        System.out.println(totolAmount);

        return totolAmount;
    }


}
