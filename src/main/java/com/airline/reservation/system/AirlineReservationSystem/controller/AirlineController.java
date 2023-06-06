package com.airline.reservation.system.AirlineReservationSystem.controller;
import com.airline.reservation.system.AirlineReservationSystem.entity.FlightEntity;
import com.airline.reservation.system.AirlineReservationSystem.repository.FlightRepo;
import com.airline.reservation.system.AirlineReservationSystem.repository.ReservationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/operation/airline")
public class AirlineController {

    @Autowired
    private FlightRepo flightRepo;

    @RequestMapping
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("departureDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date departureDate, Model model){

        List<FlightEntity> flights =  flightRepo.findByDepartureCityAndArrivalCityDepartureDate(from,to, departureDate);

        model.addAttribute("flights",flights);
        return "displayFlights";
    }

    @RequestMapping("admin/showAddFlight")
    public String showAddFlight(){
        return "addFlight";
    }


}
