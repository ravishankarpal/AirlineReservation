package com.airline.reservation.system.AirlineReservationSystem.repository;

import com.airline.reservation.system.AirlineReservationSystem.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<PassengerEntity,Integer > {

}
