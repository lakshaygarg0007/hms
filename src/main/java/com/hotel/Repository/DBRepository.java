package com.hotel.Repository;

import com.hotel.bean.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBRepository extends CrudRepository<Manager,String>{

}
