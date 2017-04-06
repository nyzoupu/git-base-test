package com.java.muti_thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Paulsen
 *
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(4);
        cachedThreadPool.execute( new Runnable() {
            
            @Override
            public void run() {
            }
        });
        int activeThread = ((ThreadPoolExecutor)cachedThreadPool).getActiveCount();
        System.out.println(activeThread);
    }
}
