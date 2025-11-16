package com.xworkz.boot_modules.mysql.repository;

import com.xworkz.boot_modules.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity , Integer> {

    List<UserEntity> findByNameContainingIgnoreCase(String name);


}
