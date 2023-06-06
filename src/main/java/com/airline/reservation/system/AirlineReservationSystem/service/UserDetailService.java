package com.airline.reservation.system.AirlineReservationSystem.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public interface UserDetailService {

    UserDetails loadUserByEmail(String email);



}
