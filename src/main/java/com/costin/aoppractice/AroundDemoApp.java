package com.costin.aoppractice;

import com.costin.aoppractice.config.AppConfig;
import com.costin.aoppractice.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundDemoApp {
    private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info(trafficFortuneService.getFortune(false));

        context.close();
    }
}
