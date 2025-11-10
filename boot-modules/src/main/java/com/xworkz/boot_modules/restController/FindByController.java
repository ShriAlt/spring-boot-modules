package com.xworkz.boot_modules.restController;

import com.xworkz.boot_modules.dto.AddressDto;
import com.xworkz.boot_modules.entity.AddressEntity;
import com.xworkz.boot_modules.service.FindByService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findBy")
public class FindByController {

    private final FindByService findByService;

    public FindByController(FindByService findByService){
        this.findByService = findByService;
    }

    @GetMapping("/name")
    public ResponseEntity<String > findUserByName(String name){
        List<AddressEntity> addressDtos = findByService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(addressDtos.toString());
    }
}
