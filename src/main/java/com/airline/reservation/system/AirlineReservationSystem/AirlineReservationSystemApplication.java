package com.airline.reservation.system.AirlineReservationSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

public class AirlineReservationSystemApplication {

	public static final Logger log = LoggerFactory.getLogger(AirlineReservationSystemApplication.class);
	public static void main(String[] args) {
		System.out.println("Current Directory = " + System.getProperty("user.dir"));
		SpringApplication.run(AirlineReservationSystemApplication.class, args);
		log.info("just a test info log");
	}


}
