package com.flavio.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.flavio.cursomc.services.DBService;
import com.flavio.cursomc.services.EmailService;
import com.flavio.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiaceDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		dbService.instantiaceTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailservice() {
		return new SmtpEmailService();
	}
}
