package com.airline.reservation.system.AirlineReservationSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "checked_in")
    private Integer checkedIn;

    @Column(name = "num_of_bags")
    private Integer numOfBags;

    @OneToOne
    private PassengerEntity passenger;

    @OneToOne
    private FlightEntity flight;


}
