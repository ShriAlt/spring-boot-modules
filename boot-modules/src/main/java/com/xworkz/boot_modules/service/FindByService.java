package com.xworkz.boot_modules.service;

import com.xworkz.boot_modules.dto.AddressDto;
import com.xworkz.boot_modules.dto.UserDto;
import com.xworkz.boot_modules.mysql.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FindByService {

    List<List<AddressDto>> findByName(String name);

    Page<UserDto> findAllUsers(Pageable pageable);

    UserEntity findById(String id);

}
