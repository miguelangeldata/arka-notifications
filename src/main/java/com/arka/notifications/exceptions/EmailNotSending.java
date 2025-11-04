package com.arka.notifications.exceptions;

public class EmailNotSending extends RuntimeException {
    public EmailNotSending(String message, Exception e) {
        super(message);
    }
}
