package com.tushar.Mails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailsService {

        @Autowired
        public JavaMailSender emailSender;

        public void sendSimpleMessage(String to, String subject, String text) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        }

        public void sendMessageWithAttachment(String to, String subject, String text) throws MessagingException {
            MimeMessage message = emailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper;
            mimeMessageHelper = new MimeMessageHelper(message, true);

            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);

            ClassPathResource path = new ClassPathResource("movies.jpg");
            mimeMessageHelper.addAttachment("Movies.jpg", path);

            emailSender.send(message);
        }
}
