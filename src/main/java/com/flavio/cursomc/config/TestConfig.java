package com.flavio.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.flavio.cursomc.services.DBService;
import com.flavio.cursomc.services.EmailService;
import com.flavio.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiaceDatabase() throws ParseException {
		dbService.instantiaceTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailservice() {
		return new MockEmailService();
	}
	
}
