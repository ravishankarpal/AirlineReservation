package com.airline.reservation.system.AirlineReservationSystem.controller;

import com.airline.reservation.system.AirlineReservationSystem.dto.ReservationRequestDto;
import com.airline.reservation.system.AirlineReservationSystem.entity.FlightEntity;
import com.airline.reservation.system.AirlineReservationSystem.repository.FlightRepo;
import com.airline.reservation.system.AirlineReservationSystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private ReservationService reservationService;


    @RequestMapping("/{id}")
    public String showCompleteRegistration(@PathVariable("id") Integer id, Model model){
       FlightEntity flight =  flightRepo.findByIds(id);
       model.addAttribute("flight",flight);
       return  "completeReservation";
    }

    @PostMapping("/complete-registration")
    public  String completeRegistration(@ModelAttribute ReservationRequestDto reservationRequestDto, Model model){
        reservationService.bookFlight(reservationRequestDto);
        model.addAttribute("message","Congratulations! Flight Booked Successfully");
        return "reservationConfirmation";
    }
}
