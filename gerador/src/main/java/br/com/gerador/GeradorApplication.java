package br.com.gerador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GeradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeradorApplication.class, args);
	}

}
