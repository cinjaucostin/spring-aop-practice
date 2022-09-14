package com.costin.aoppractice.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(boolean makeSomeTrouble) {
        // simulate a delay

        if(makeSomeTrouble) {
            throw new RuntimeException("Problems varule problems...");
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Se circula mizer ca idee.";
    }

}
