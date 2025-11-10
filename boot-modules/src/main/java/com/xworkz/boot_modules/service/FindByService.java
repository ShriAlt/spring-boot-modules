package com.xworkz.boot_modules.service;

import com.xworkz.boot_modules.entity.AddressEntity;

import java.util.List;

public interface FindByService {

    List<AddressEntity> findByName(String name);


}
