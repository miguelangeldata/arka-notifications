package com.arka.notifications.service;

import com.arka.notifications.exceptions.EmailNotSending;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j


public class NotificationService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public void sendNotification(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(senderEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        try {
            mailSender.send(message);
            log.info("Email was sending Successfully to: {}", toEmail);
        } catch (Exception e) {
            log.error("ERROR sending email to {}: {}", toEmail, e.getMessage());
            throw new EmailNotSending("Fail Into Notification Service", e);
        }
    }
}

