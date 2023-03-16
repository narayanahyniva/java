package com.sping.employeeAddress.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
@Configuration("Propertyconfig")
@Data
@NoArgsConstructor
public class Propertyconfig {

    private long id;

    private String name;

    private String email;
}
