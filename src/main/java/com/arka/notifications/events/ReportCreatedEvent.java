package com.arka.notifications.events;

import lombok.Getter;

@Getter
public class ReportCreatedEvent {
    private String id;
    private String toEmail;
    private String csvReportURl;
    private String pdfReportUrl;
}
