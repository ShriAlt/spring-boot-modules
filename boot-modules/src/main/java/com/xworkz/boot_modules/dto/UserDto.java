package com.xworkz.boot_modules.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {



    private String name;
    private String email;
    private String phoneNumber;
}
