package com.xworkz.boot_modules.repository;

import com.xworkz.boot_modules.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity , Integer> {

}
