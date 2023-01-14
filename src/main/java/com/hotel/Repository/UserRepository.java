package com.hotel.Repository;

import com.hotel.bean.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByUserIdAndPassword(String userId, String password);
}
