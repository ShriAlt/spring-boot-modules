package com.xworkz.boot_modules.restController;

import com.xworkz.boot_modules.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/h2Users")
public class TestController {


    @PostMapping
    public ResponseEntity<String> saveUser(UserDto dto){

        return ResponseEntity.status(HttpStatus.OK).body("User Saved");
    }
}
