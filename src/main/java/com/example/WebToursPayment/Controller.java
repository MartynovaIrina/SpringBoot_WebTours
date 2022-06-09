package com.example.WebToursPayment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    private static final String template = "OK";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/payment")
    public PaymentAnswer answer(String name) {
        return new PaymentAnswer(counter.incrementAndGet(), template);
    }
}