package com.airline.reservation.system.AirlineReservationSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "roles")

    private Set<UserEntity> users;

    @Override
    public String getAuthority(){
        return  name;
    }

}
