package com.airline.reservation.system.AirlineReservationSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FlightEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "flight_number")
    private String flightNumber;


    @Column(name = "operating_airlines")
    private String operatingAirlines;

    @Column(name = "departure_city")
    private  String departureCity;

    @Column(name = "arrival_city")
    private String arrivalCity;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "estimated_departure_time")
    private Timestamp estimatedDepartureTime;

    @Column(name = "estimated_arrival_time")
    private  Timestamp estimatedArrivalTime;


}
