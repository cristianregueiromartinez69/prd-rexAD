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

	//TODO: crear logica para recibir datos de con-external y mandarlo a bases de datos y ficheros

}
