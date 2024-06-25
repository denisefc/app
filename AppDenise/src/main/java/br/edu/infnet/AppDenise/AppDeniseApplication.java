package br.edu.infnet.AppDenise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppDeniseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDeniseApplication.class, args);
	}

}
