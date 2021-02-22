package com.hotel.Service.manager;

import com.hotel.Repository.ManagerExpenseRepository;
import com.hotel.bean.manager.ManagerExpense;
import com.hotel.bean.manager.ManagerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManagerExpenseService {
    @Autowired
    ManagerExpenseRepository managerExpenseRepository;
    public void addExpense(String hotelId, Double transaction, Date date){
        ManagerExpense managerExpense=new ManagerExpense(hotelId,transaction,date);
        managerExpenseRepository.save(managerExpense);
    }

    public List<ManagerExpense> expenseHistory(String hotelId, Date startingDate, Date endingDate){
        return managerExpenseRepository.findByHotelIdAndDateBetween(hotelId,startingDate, endingDate);
    }

}
