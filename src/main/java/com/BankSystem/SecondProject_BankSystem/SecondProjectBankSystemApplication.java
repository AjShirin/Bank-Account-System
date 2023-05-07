package com.BankSystem.SecondProject_BankSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableScheduling
@EnableWebSecurity // security is active so nothing will work
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecondProjectBankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondProjectBankSystemApplication.class, args);
	}

}
