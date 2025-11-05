package com.xworkz.boot_modules.entity;

import com.xworkz.boot_modules.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String landmark;
    private String addressType;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private UserEntity user;
}
