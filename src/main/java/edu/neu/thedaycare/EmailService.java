package edu.neu.thedaycare;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		
		mailSenderImpl.setHost(EmailConfiguration.host);
		mailSenderImpl.setPort(EmailConfiguration.port);
		mailSenderImpl.setUsername(EmailConfiguration.username);
		mailSenderImpl.setPassword(EmailConfiguration.password);
		
		return mailSenderImpl;
	}

	public void sendSimpleMessage(String to, String from, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		message.setFrom(from);
		getJavaMailSender().send(message);
	}
}
