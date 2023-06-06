package com.airline.reservation.system.AirlineReservationSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ReservationUpdateRequestDto {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private Integer numOfBags;

    @JsonProperty
    private  Integer checkedIn;
}
