package com.xworkz.boot_modules.service;

import com.xworkz.boot_modules.dto.AddressDto;
import com.xworkz.boot_modules.dto.UserDto;
import com.xworkz.boot_modules.entity.AddressEntity;
import com.xworkz.boot_modules.entity.UserEntity;
import com.xworkz.boot_modules.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindByServiceImpl implements FindByService{

   private final UserRepository userRepository;

    public FindByServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<List<AddressDto>> findByName(String name) {

        List<List<AddressDto>> lists = new ArrayList<>();
        for(UserEntity entity : userRepository.findByName(name)){
            List<AddressDto> addressDtos = new ArrayList<>();
            for (AddressEntity addressEntity : entity.getAddresses()){
                AddressDto addressDto = new AddressDto();
                BeanUtils.copyProperties(addressEntity,addressDto);
                addressDtos.add(addressDto);
            }
            lists.add(addressDtos);
        }
        return lists;
    }

    @Override
    public Page<UserDto> findAllUsers(Pageable pageable) {

        Page<UserEntity> all = userRepository.findAll(pageable);

        List<UserEntity> userEntities = all.get().toList();
        List<UserDto> userDtos = new ArrayList<>();

        userEntities.forEach(userEntity -> {
            List<AddressDto> addressDtos = new ArrayList<>();
            List<AddressEntity> addresses = userEntity.getAddresses();

            addresses.forEach(addressEntity -> {
                AddressDto addressDto = new AddressDto();
                BeanUtils.copyProperties(addressEntity,addressDto);
                addressDtos.add(addressDto);
            });
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity,userDto);
            userDto.setAddressDtos(addressDtos);
            userDtos.add(userDto);
        });



        return ;
    }
}
