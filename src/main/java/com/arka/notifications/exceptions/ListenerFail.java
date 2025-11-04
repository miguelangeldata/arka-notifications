package com.arka.notifications.exceptions;

public class ListenerFail extends RuntimeException {
    public ListenerFail(String message, Exception e) {
        super(message);
    }
}
