package com.cristianProyectoAD.prd_rex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PrdRexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrdRexApplication.class, args);
	}

	//TODO: prparar a prd-rex para consultas por fecha de lectura

}
