package com.arka.notifications;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class testNotifications {

    @GetMapping
    public String hello(){
        return "hello";
    }
}
