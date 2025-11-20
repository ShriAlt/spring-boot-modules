package com.xworkz.boot_modules.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheckUp implements HealthIndicator {


    @Override
    public Health health() {
        if (isHealthy()){
            return Health.up().withDetail("healthCheck","all is working fine").build();
        }
        return Health.down().withDetail("healthCheck","Not working").build();
    }

    private boolean isHealthy(){
        return false;
    }
}
