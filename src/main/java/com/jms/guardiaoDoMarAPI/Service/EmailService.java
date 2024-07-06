package com.jms.guardiaoDoMarAPI.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private final JavaMailSender emailSender;
		
	public EmailService(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}

	@Async
	public void enviarEmailRecuperacaoDeSenha(String email, int token) {
		
		StringBuffer mensagemBuffer = new StringBuffer("Foi solicitado uma alteração de senha da sua conta\n\n");
		
		mensagemBuffer.append("Insira o seguinte código (válido por 1 hora) para criar uma nova senha: " + token);

		enviarEmail(email, "GUARDIÃO DO MAR - RECUPERAÇÃO DE SENHA", mensagemBuffer.toString());
	}
	
	private Boolean enviarEmail(String destinatario, String assunto, String mensagem) {
		
		try {
			
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setFrom("debugsolucoestecnologicas@gmail.com");
			
			message.setTo(destinatario);
			
			message.setSubject(assunto);
			
			message.setText(mensagem);
			
			emailSender.send(message);
			
			return true;
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
			return false;
		}
	}
}
