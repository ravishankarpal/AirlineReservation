package com.airline.reservation.system.AirlineReservationSystem.controller;

import com.airline.reservation.system.AirlineReservationSystem.dto.ReservationUpdateRequestDto;
import com.airline.reservation.system.AirlineReservationSystem.entity.ReservationEntity;
import com.airline.reservation.system.AirlineReservationSystem.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationRestController {

    @Autowired
    private ReservationRepo reservationRepo;

    @RequestMapping("/reservations/{id}")
    public ReservationEntity findReservation(@PathVariable Integer id){
        return reservationRepo.findById(id).get();
    }


    @PostMapping("/reservations")
    public ReservationEntity updateReservation(@RequestBody ReservationUpdateRequestDto requestDto){
        ReservationEntity currReservation = reservationRepo.findById(requestDto.getId()).get();
        currReservation.setCheckedIn(requestDto.getCheckedIn());
        currReservation.setNumOfBags(requestDto.getNumOfBags());
        return reservationRepo.save(currReservation);
    }

}
