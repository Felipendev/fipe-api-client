package com.fipe.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Fipe table API", version = "1.0", description = "API to query vehicle values from the FIPE Table"))
@SpringBootApplication
public class FipeApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FipeApiClientApplication.class, args);
	}

}
