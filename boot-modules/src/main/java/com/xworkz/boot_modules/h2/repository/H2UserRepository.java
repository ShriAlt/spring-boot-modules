package com.xworkz.boot_modules.h2.repository;

import com.xworkz.boot_modules.h2.entity.H2UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2UserRepository extends JpaRepository<H2UserEntity , Long> {


}
