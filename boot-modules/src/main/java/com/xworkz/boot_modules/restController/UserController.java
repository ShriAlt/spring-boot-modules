package com.xworkz.boot_modules.restController;

import com.xworkz.boot_modules.dto.UserDto;
import com.xworkz.boot_modules.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors().toString());
        }
        String s = service.saveAndValidate(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("user saved");
    }
    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.findAll().toString());
    }
    @DeleteMapping
    public ResponseEntity<String> delete(int id){
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted");
    }
    @PutMapping
    public ResponseEntity<String> updateUser(UserDto dto){
        String result = service.updateUser(dto);
        if (result.equals("no id")){
            return ResponseEntity.status(HttpStatus.OK).body("wrong id");
        }
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }

}
