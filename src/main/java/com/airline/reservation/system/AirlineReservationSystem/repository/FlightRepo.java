package com.airline.reservation.system.AirlineReservationSystem.repository;


import com.airline.reservation.system.AirlineReservationSystem.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FlightRepo extends JpaRepository<FlightEntity,Integer> {
    // List<FlightEntity> findByDepartureCityAndArrivalCityDepartureDate(String from, String to, Date departureDate);
    @Query(value = "Select f from FlightEntity f where id =:id")
    FlightEntity findByIds(@Param("id") Integer id);

    @Query(value = "Select f from FlightEntity f where f.departureCity=:departureCity and f.arrivalCity=:arrivalCity and f.departureDate=:departureDate")
    List<FlightEntity> findByDepartureCityAndArrivalCityDepartureDate(@Param("departureCity")String from, @Param("arrivalCity") String to, @Param("departureDate") java.util.Date departureDate);


}