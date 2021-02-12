package com.hotel.Repository;

import com.hotel.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBRepository extends CrudRepository<User,String>{

}
