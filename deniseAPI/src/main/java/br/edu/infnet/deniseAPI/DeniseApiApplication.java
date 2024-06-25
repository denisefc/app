package br.edu.infnet.deniseAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DeniseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeniseApiApplication.class, args);
	}

}
