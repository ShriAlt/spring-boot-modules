package com.xworkz.boot_modules.health;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "harsha")
public class CustomEndPoint {


    @ReadOperation
    public String myEndPoint(){
        return "Custom endPoint";
    }
}
