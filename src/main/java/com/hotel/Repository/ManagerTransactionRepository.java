package com.hotel.Repository;

import com.hotel.bean.manager.ManagerTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ManagerTransactionRepository extends CrudRepository<ManagerTransaction,Integer> {
    List<ManagerTransaction> findByHotelIdAndDate(String hotelId, Date date);
    List<ManagerTransaction> findByHotelIdAndDateBetween(String hotelId,Date starting,Date ending);
   List<ManagerTransaction> findByHotelId(String hotelId);

}
