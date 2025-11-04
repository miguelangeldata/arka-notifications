package com.arka.notifications.events;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ShippingSendEvent {
    private String id;
    private String userId;
    private String userEmail;
    private String timeEstimateToArrive;

}
