package com.jms.guardiaoDoMarAPI.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration {

	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    
	    mailSender.setHost("smtp.gmail.com");
	    
	    mailSender.setPort(587);
	    
	    mailSender.setUsername("debugsolucoestecnologicas@gmail.com");
	    
	    mailSender.setPassword("hcwx izfq enok pasb");
	    
	    Properties properties = mailSender.getJavaMailProperties();
	    
	    properties.put("mail.smtp.quitwait", "false");
	    
	    properties.put("mail.smtp.auth", "true");
	    
	    properties.put("mail.smtp.starttls.enable", "true");
	    
	    return mailSender;
	}
}
