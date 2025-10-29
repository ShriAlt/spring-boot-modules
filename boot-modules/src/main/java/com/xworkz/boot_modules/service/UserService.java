package com.xworkz.boot_modules.service;

import com.xworkz.boot_modules.dto.UserDto;

import java.util.List;

public interface UserService {

    String saveAndValidate(UserDto dto);

    List<UserDto> findAll();
}
