package com.hotel.Repository;


import com.hotel.bean.manager.ManagerExpense;
import com.hotel.bean.manager.ManagerTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerExpenseRepository extends CrudRepository<ManagerExpense,Integer> {
    @Query(value = "select expense from ManagerExpense ")
    List<ManagerExpense> findAll();
    List<ManagerExpense> findByHotelId(String hotelId);

}
