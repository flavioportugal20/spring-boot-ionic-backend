package com.flavio.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.flavio.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
