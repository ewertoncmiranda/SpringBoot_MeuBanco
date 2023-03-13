package com.orange.talents.meubanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MeuBancoApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MeuBancoApplication.class ) ;
	}



	
	public static void main(String[] args) {
		SpringApplication.run(MeuBancoApplication.class, args);
	}

	
	@RequestMapping(value = "/")
	public String ola() {
		return "Ola mundo" ;
	}
}
