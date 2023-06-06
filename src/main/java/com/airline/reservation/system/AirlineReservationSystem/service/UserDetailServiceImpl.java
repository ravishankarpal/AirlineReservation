package com.airline.reservation.system.AirlineReservationSystem.service;

import com.airline.reservation.system.AirlineReservationSystem.entity.UserEntity;
import com.airline.reservation.system.AirlineReservationSystem.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByEmail(String emailId) throws UsernameNotFoundException {

        UserEntity userName = userRepo.findByEmailId(emailId);
        if (userName == null || userName.equals(null)) {
            return (UserDetails) new UsernameNotFoundException("User doesn't exist");
        }

       // return new org.springframework.security.core.userdetails.User(userName.getEmailId(),userName.getPassword(),userName.getUserRoles());
        return  null;
    }

}
