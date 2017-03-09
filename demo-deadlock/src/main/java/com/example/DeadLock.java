package com.example;

import org.springframework.stereotype.Component;

/**
 * Created by ucs_lanxuesong on 2017/3/8.
 */
@Component
public class DeadLock {

    private final Object left = new Object();
    private final Object right = new Object();

    public void left2Right() throws Exception {
        synchronized (left) {
            System.out.println("left2Right start!");
            Thread.sleep(2000);
            synchronized (right) {
                System.out.println("left2Right done!");
            }
        }
    }

    public void right2Left() throws Exception {
        synchronized (right) {
            System.out.println("right2Left start!");
            Thread.sleep(2000);
            synchronized (left) {
                System.out.println("right2Left done!");
            }
        }
    }
}
