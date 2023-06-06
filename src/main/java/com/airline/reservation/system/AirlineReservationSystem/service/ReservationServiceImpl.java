package com.airline.reservation.system.AirlineReservationSystem.service;

import com.airline.reservation.system.AirlineReservationSystem.dto.ReservationRequestDto;
import com.airline.reservation.system.AirlineReservationSystem.entity.FlightEntity;
import com.airline.reservation.system.AirlineReservationSystem.entity.PassengerEntity;
import com.airline.reservation.system.AirlineReservationSystem.entity.ReservationEntity;
import com.airline.reservation.system.AirlineReservationSystem.repository.FlightRepo;
import com.airline.reservation.system.AirlineReservationSystem.repository.PassengerRepo;
import com.airline.reservation.system.AirlineReservationSystem.repository.ReservationRepo;
import com.airline.reservation.system.AirlineReservationSystem.util.PdfGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Slf4j
@Service
public  class ReservationServiceImpl implements ReservationService {


    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private PassengerRepo passengerRepo;

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private PdfGenerator pdfGenerator;

    @Override
    public  ReservationEntity bookFlight(ReservationRequestDto reservationRequestDto){
        log.info("going to save passengers details");
        ReservationEntity savedRegistrationDetails = null;
        try {
            FlightEntity flight = flightRepo.findByIds(reservationRequestDto.getFlightId());;
            PassengerEntity passenger = new PassengerEntity();
            passenger.setFirstName(reservationRequestDto.getPassengerFirstName());
            passenger.setLastName(reservationRequestDto.getPassengerLastName());
            passenger.setEmail(reservationRequestDto.getPassengerEmail());
            passenger.setPhone(reservationRequestDto.getPassengerPhone());
            PassengerEntity savedPassengerDetails = passengerRepo.save(passenger);
            log.info("Passengers details has been saved successfully!",passenger.getId());
            ReservationEntity reservation = new ReservationEntity();
            reservation.setCheckedIn(0);
            reservation.setFlight(flight);
            reservation.setPassenger(savedPassengerDetails);
             savedRegistrationDetails =  reservationRepo.save(reservation);
            log.info("Reservation details has been saved successfully!",reservation.getId());
            String pdfFilePath = Paths.get("").toAbsolutePath().toString() +
                    savedRegistrationDetails.getId() + ".pdf";
            pdfGenerator.initiatePdf(reservation, pdfFilePath);
            //return savedRegistrationDetails;

        }catch (Exception e){
            log.info("Passengers and reservations details has not been saved due to exception!",e);
        }
        return  savedRegistrationDetails;

    }
}
