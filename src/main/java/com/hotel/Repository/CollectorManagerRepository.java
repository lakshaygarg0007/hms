package com.hotel.Repository;

import com.hotel.bean.collector.collectorHotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CollectorManagerRepository extends CrudRepository<collectorHotel,String>
{
    @Query(value = "select count(CH.hotelId), CH.collectorID from collectorHotel as CH group by CH.collectorID order by count(CH.hotelId) asc ")
    List<Object[]> findAllCollectors();

    List<collectorHotel> findByCollectorID(String collectorId);


}