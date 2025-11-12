package com.arka.notifications.listeners;

import com.arka.notifications.events.PaymentAcceptedEvent;
import com.arka.notifications.events.PaymentRejectedEvent;
import com.arka.notifications.events.ReportCreatedEvent;
import com.arka.notifications.events.ShippingSendEvent;
import com.arka.notifications.exceptions.ListenerFail;
import com.arka.notifications.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Slf4j
public class Listener {
    private final NotificationService notificationService;
    @Bean
    public Consumer<PaymentAcceptedEvent> paymentAcceptedEventListener(){
        return event -> {
            log.info(" Listener active. Event received for event: {}", event.getId());
            try {
                String subject = "¡Payment Accepted!";
                String body= "!Your Payment was Successfully accepted," +
                        "your order soon will be in your address";
                notificationService.sendNotification(event.getUserEmail(),subject,body);
                log.info("Notification Successfully was Send to {}", event.getUserEmail());
            }catch (Exception e) {
                log.error(" Fail to process {}",e.getMessage());
                throw new ListenerFail("Fail listened the event", e);
            }
        };
    }
    @Bean
    public Consumer<PaymentRejectedEvent> paymentRejectedEventListener(){
        return event->{
            log.info(" Listener active. Event received for event: {}", event.getId());
            try {
                String subject = "¡Payment Rejected!";
                String body= "!Your payment was rejected" +
                        "Please contact to you bak provider";
                notificationService.sendNotification(event.getUserEmail(),subject,body);
                log.info("Notification Successfully was Send to {}", event.getUserEmail());
            }catch (Exception e) {
                log.error(" Fail to process {}",e.getMessage());
                throw new ListenerFail("Fail listened the event", e);
            }
        };
    }
    @Bean
    public Consumer<ShippingSendEvent> shippingSendEventListener(){
        return event->{
            log.info(" Listener active. Event received for event: {}", event.getId());
            try {
                String subject = "¡Shipping Send !";
                String body= "!Your shipping was send " +
                        "it will be in your home at : "+event.getTimeEstimateToArrive();
                notificationService.sendNotification(event.getUserEmail(),subject,body);
                log.info("Notification Successfully was Send to {}", event.getUserEmail());
            }catch (Exception e) {
                log.error(" Fail to process {}",e.getMessage());
                throw new ListenerFail("Fail listened the event", e);
            }
        };
    }
    @Bean
    public Consumer<ReportCreatedEvent> reportSendEventListener(){
        return event->{
            log.info(" Listener active. Event received for event: {}", event.getId());
            try {
                String subject = "¡Here is your Report !";
                String body= "¡It is the report for the last 8 days! " +
                        "Follow these links to download your files:\n\n" +
                        "CSV Report: " + event.getCsvReportURl() + "\n" +
                        " PDF Report: " + event.getPdfReportUrl();
                notificationService.sendNotification(event.getToEmail(),subject,body);
                log.info("Notification Successfully was Send to {}", event.getToEmail());
            }catch (Exception e) {
                log.error(" Fail to process {}",e.getMessage());
                throw new ListenerFail("Fail listened the event", e);
            }
        };
    }

}
