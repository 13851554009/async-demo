package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Client {
    @Autowired
    private WorkService workService;

    @Test
    public void main() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Future<String> work1 = workService.work1();
        Future<String> work2 = workService.work2();
        Future<String> work3 = workService.work3();
        int count = 0;
        while (true){
            if(work1.isDone()&&work2.isDone()&&work3.isDone()){
                System.out.println(work1.get());
                System.out.println(work2.get());
                System.out.println(work3.get());
                break;
            }
            count++;
//            Thread.sleep(100);
        }
        long end = System.currentTimeMillis();
        System.out.println("count " +count);
        System.out.println("耗时 " +(end -start));
    }
}
