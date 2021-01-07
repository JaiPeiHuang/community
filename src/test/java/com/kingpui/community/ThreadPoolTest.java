package com.kingpui.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class ThreadPoolTest {
    private static  final Logger logger = LoggerFactory.getLogger(ThreadPoolTest.class);

    // JDK普通线程池
    private ExecutorService executorService= Executors.newFixedThreadPool(5);

    // JDK可执行定时任务的线程池
    private ScheduledExecutorService scheduledExecutorServic = Executors.newScheduledThreadPool(5);

    private void sleep(long m){
        try {
            Thread.sleep(m);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    // 1.JDK普通线程池
    @Test
    public void testExecutorService(){
        Runnable task = new Runnable() {
            int i=0;
            @Override
            public void run() {
                logger.debug("Hello ExecutorService");
                System.out.println(i++);
            }
        };

        for (int i = 0; i <10 ; i++) {
            executorService.submit(task);
        }
        sleep(10000);
    }

    // 2.JDK定时任务线程池
    @Test
    public void testScheuledExecutorService(){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                logger.debug("hello SchduledExecutorService");
            }
        };
        scheduledExecutorServic.scheduleAtFixedRate(task,10000,1000, TimeUnit.SECONDS);

        sleep(30000);
        System.out.println("1");
    }
}