package com.arka.notifications.resources;

public record EmailRequest(String toEmail, String subject, String body) {
}
