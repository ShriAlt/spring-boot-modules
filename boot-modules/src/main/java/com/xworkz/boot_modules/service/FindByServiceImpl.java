package com.xworkz.boot_modules.service;

import com.xworkz.boot_modules.entity.AddressEntity;
import com.xworkz.boot_modules.entity.UserEntity;
import com.xworkz.boot_modules.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FindByServiceImpl implements FindByService{

   private final UserRepository userRepository;

    public FindByServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<AddressEntity> findByName(String name) {
        List<UserEntity> users = userRepository.findByName(name);
        List<AddressEntity> addresses = new ArrayList<>();
        for (UserEntity user : users) {
            if (user.getAddresses() != null) {
                addresses.addAll(user.getAddresses());
            }
        }
        addresses.forEach(System.out::println);
        return addresses;
    }

}
