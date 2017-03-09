package com.example;

/**
 * Created by ucs_lanxuesong on 2017/3/8.
 */
public class DeadLockTest {

    private static DeadLock lock = new DeadLock();

    public static void main(String[] args) {

        L2RThread t1 = new L2RThread(lock);
        R2LThread t2 = new R2LThread(lock);
        new Thread(t1).start();
        new Thread(t2).start();
    }

    static class L2RThread implements Runnable {

        private DeadLock dl;

        L2RThread(DeadLock dl) {
            this.dl = dl;
        }

        @Override
        public void run() {
            try {
                dl.left2Right();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class R2LThread implements Runnable {

        private DeadLock dl;

        R2LThread(DeadLock dl) {
            this.dl = dl;
        }

        @Override
        public void run() {
            try {
                dl.right2Left();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
