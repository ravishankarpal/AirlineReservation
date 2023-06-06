package com.airline.reservation.system.AirlineReservationSystem.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SecurityServiceImpl implements  SecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private  UserDetailService userDetailService;
    @Override
    public boolean isLogin(String email, String password){
       boolean state = false;
        UserDetails userDetails = userDetailService.loadUserByEmail(email);
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        state = token.isAuthenticated();
        if (state){
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        return  state;
    }

}
