package com.xworkz.boot_modules.restController;

import com.xworkz.boot_modules.dto.UserDto;
import com.xworkz.boot_modules.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }

    @PostMapping("createUser")
    public ResponseEntity<String> createUser(UserDto dto){
        service.saveAndValidate(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("user saved");
    }

    @GetMapping("findAll")
    public ResponseEntity<String> findAll(){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.findAll().toString());
    }}
