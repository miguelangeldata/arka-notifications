package com.arka.notifications.controllers;

import com.arka.notifications.resources.EmailRequest;
import com.arka.notifications.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
@RequiredArgsConstructor
public class EmailController {
    private final NotificationService service;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        service.sendNotification(request.toEmail(),request.subject(),request.body());
        String message="email was send successfully";
        return ResponseEntity.ok(message);
    }
}
