package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class WorkService {
    private static final Logger logger = LoggerFactory.getLogger(WorkService.class);

    @Async
    public Future<String> work1() throws InterruptedException {
        logger.info("work1 is working ");
        sleep();
        return new AsyncResult<>("work1 is done");
    }

    @Async
    public Future<String> work2() throws InterruptedException {
        logger.info("work2 is working ");
        sleep();
        return new AsyncResult<>("work2 is done");
    }

    @Async
    public Future<String> work3() throws InterruptedException {
        logger.info("work3 is working ");
        sleep();
        return new AsyncResult<>("work3 is done");
    }

    private static void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
