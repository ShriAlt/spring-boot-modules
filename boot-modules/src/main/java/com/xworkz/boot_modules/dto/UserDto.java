package com.xworkz.boot_modules.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto {
    private int updateId;
    private String name;
    private String email;
    private String phoneNumber;
}