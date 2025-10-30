package com.xworkz.boot_modules.restController;

import com.xworkz.boot_modules.dto.UserDto;
import com.xworkz.boot_modules.service.UserService;
import com.xworkz.boot_modules.wrapper.UserDataWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("users")
public class UsersController {
    private final UserService service;

    public UsersController(UserService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<String> createUsers(@RequestBody UserDataWrapper userDataWrapper) {
        List<UserDto> userDtos = userDataWrapper.getUserDtos();
        if (userDtos == null || userDtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no users provided");
        }
        String result = service.saveUsers(userDtos);
        if ("notOK".equals(result)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not Ok");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("user saved");
    }
}
//String result = service.saveUsers(userDataWrapper.getUserDtos());
//        if (result.equals("notOK")){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not Ok");
//        }