package com.xworkz.boot_modules.mysql.service;

import com.xworkz.boot_modules.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public interface UsersService {

    String saveUsers(List<UserDto> userDtos);

    ArrayList<String> updateUsers(List<UserDto> userDtos);

    String deleteUsers(List<Integer> ids);
}
