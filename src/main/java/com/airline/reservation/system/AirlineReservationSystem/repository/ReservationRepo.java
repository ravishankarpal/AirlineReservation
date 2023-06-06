package com.airline.reservation.system.AirlineReservationSystem.repository;

import com.airline.reservation.system.AirlineReservationSystem.entity.FlightEntity;
import com.airline.reservation.system.AirlineReservationSystem.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepo extends JpaRepository<ReservationEntity, Integer> {


}
