package com.airline.reservation.system.AirlineReservationSystem.controller;

import com.airline.reservation.system.AirlineReservationSystem.entity.UserEntity;
import com.airline.reservation.system.AirlineReservationSystem.repository.UserRepo;
import com.airline.reservation.system.AirlineReservationSystem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;



    private SecurityService securityService;

    @RequestMapping("/loginUser")
    public String userLogin(){
        return "login/login";

    }

    @RequestMapping("/registerUser")
    public String userRegistration(){

        return "login/registration";
    }



    @PostMapping("/user/login/update")
    public String userLoginUpdate(@RequestParam("email") String email,
                                  @RequestParam("password") String password, ModelMap modelMap){
       boolean isUserExist = securityService.isLogin(email, password);
       if (isUserExist){
           return "findFlights";
       }
       else{
           modelMap.addAttribute("message","Invalid credentials!");
       }
       return "login/login";
    }

    @PostMapping("/user/registration/update")
    public String userLoginUpdate(@ModelAttribute UserEntity userEntity){
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userRepo.save(userEntity);
        return "login/registration";

    }

}
