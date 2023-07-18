package com.example.demo;

import org.springframework.boot.SpringApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(name = "javainuseapi", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER,bearerFormat = "JWT")
@OpenAPIDefinition(info = @Info(title = "Student Course API", version = "2.0", description = "Student Course  Information"))
public class Demoh2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demoh2Application.class, args);
	}


}
