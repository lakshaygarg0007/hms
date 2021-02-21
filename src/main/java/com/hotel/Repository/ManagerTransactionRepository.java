package com.hotel.Repository;

import com.hotel.bean.manager.HotelIdSerialNumber;
import com.hotel.bean.manager.ManagerTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerTransactionRepository extends CrudRepository<ManagerTransaction, HotelIdSerialNumber> {
    List<ManagerTransaction> findByHotelIdAndDate(String hotelId, Date date);
    List<ManagerTransaction> findByDateBetween(Date starting,Date ending);

   List<ManagerTransaction> findById(String hotelId);
}
