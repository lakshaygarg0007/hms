package com.hotel.Repository;

import com.hotel.bean.collector.CollectorCollection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollectorCollectionsRepository extends CrudRepository<CollectorCollection,Integer> {
    @Query(value = "select s from CollectorCollection s where s.requestAccepted=true and s.collectorId=:collectorId")
    List<CollectorCollection> findByCollectorId(String collectorId);

    @Query(value = "select s from CollectorCollection s where s.requestAccepted=false and s.approverId=:approverId")
    List<CollectorCollection> findByApproverId(String approverId);

    @Query(value = "select s from CollectorCollection s where s.requestAccepted=true and s.hotelId=:hotelId")
    List<CollectorCollection> findByHotelId(String hotelId);
    List<CollectorCollection> findByApproverIdAndCollectorId(String approverId,String collectorId);
    List<CollectorCollection> findBySerialNumber(int serialNumber);
}
