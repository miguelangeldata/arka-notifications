package com.arka.notifications.events;

import lombok.Getter;

import java.util.UUID;

@Getter
public class PaymentAcceptedEvent {
    private String id;
    private String userId;
    private String userEmail;
}
