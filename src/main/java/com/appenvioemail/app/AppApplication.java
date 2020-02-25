package com.appenvioemail.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

    @Autowired
    private JavaMailSender javaMailSender;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws MessagingException, IOException {
		System.out.println("Enviando...");
		sendEmail();
        System.out.println("Enviado!");
    }

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("gabrielgustavoandrade@gmail.com");
        msg.setSubject("App de envio de e-mail spring");
		msg.setText("Hello World");
		
		System.out.println("Enviando para: " + msg.getTo().toString());
		System.out.println("Assunto: " + msg.getSubject());

        javaMailSender.send(msg);

    }
}
