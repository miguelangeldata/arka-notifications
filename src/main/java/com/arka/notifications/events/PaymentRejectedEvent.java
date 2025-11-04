package com.arka.notifications.events;

import lombok.Getter;

@Getter
public class PaymentRejectedEvent {
    private String id;
    private String userId;
    private String userEmail;
}
