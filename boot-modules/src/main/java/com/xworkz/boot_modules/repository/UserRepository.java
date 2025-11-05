package com.xworkz.boot_modules.repository;

import com.xworkz.boot_modules.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity , Integer> {


    List<UserEntity> findByNameContainingIgnoreCase(String name);

}
