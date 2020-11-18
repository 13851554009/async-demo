package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class Runner implements CommandLineRunner {
    @Autowired
    WorkService workService;

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();
        Future<String> work1 = workService.work1();
        Future<String> work2 = workService.work2();
        Future<String> work3 = workService.work3();
        while (true){
            if(work1.isDone()&&work2.isDone()&&work3.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时 " +(end -start));
    }
}
