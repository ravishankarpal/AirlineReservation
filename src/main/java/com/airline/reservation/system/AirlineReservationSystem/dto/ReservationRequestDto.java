package com.airline.reservation.system.AirlineReservationSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDto {
    @JsonProperty
    private Integer flightId;

    @JsonProperty
    private String passengerFirstName;

    @JsonProperty
    private String passengerLastName;

    @JsonProperty
    private String passengerEmail;

    @JsonProperty
    private String passengerPhone;

    @JsonProperty
    private String nameOnCard;

    @JsonProperty
    private String cardNumber;

    @JsonProperty
    private String expiryDate;

    @JsonProperty
    private Integer cvvNumber;

    @JsonProperty
    private String upiId;
}
