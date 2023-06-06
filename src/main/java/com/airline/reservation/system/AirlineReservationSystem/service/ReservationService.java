package com.airline.reservation.system.AirlineReservationSystem.service;

import com.airline.reservation.system.AirlineReservationSystem.dto.ReservationRequestDto;
import com.airline.reservation.system.AirlineReservationSystem.entity.ReservationEntity;

public interface ReservationService {

    ReservationEntity bookFlight(ReservationRequestDto reservationRequestDto);

}
