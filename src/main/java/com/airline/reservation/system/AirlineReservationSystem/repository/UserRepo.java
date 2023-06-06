package com.airline.reservation.system.AirlineReservationSystem.repository;

import com.airline.reservation.system.AirlineReservationSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {


    UserEntity findByEmailId(String emailId);
}
