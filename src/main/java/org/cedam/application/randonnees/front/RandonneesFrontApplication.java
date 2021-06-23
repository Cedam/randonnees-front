package org.cedam.application.randonnees.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("org.cedam.application")
@EnableDiscoveryClient
//@EnableSwagger2
public class RandonneesFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandonneesFrontApplication.class);
	}

}
