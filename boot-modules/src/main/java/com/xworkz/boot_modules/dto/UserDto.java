package com.xworkz.boot_modules.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class UserDto {
    private int updateId;

    @NotBlank(message = "Customer name is required")
    private String name;
    private String email;
    private String phoneNumber;
}