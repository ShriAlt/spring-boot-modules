package com.xworkz.boot_modules.service;

import com.xworkz.boot_modules.dto.UserDto;
import com.xworkz.boot_modules.entity.UserEntity;
import com.xworkz.boot_modules.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository userRepository){
        this.repository=userRepository;
    }

    @Override
    public String saveAndValidate(UserDto dto) {
        if(dto == null){
            return "nullError";
        }
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(dto,entity);
        repository.save(entity);
        return "OK";
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> dtos = new ArrayList<>();
        for(UserEntity entity : repository.findAll()){
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(entity,dto);
            dtos.add(dto);
        }
        return dtos ;
    }

    @Override
    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    @Override
    public String updateUser(UserDto dto) {
        Optional<UserEntity> exists = repository.findById(dto.getUpdateId());
        if (exists.isEmpty()){
            return "no id";
        }
       UserEntity userEntity = exists.get();
        userEntity.setEmail(dto.getEmail());
        userEntity.setName(dto.getName());
        userEntity.setPhoneNumber(dto.getPhoneNumber());
        repository.save(userEntity);
        return "ok";
    }
}
