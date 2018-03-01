package com.anysolutions.demo5;

public class Demo5 {
    private int count = 0;

    public static void main(String args[]) {
        Demo5 app = new Demo5();
        app.doWork();
    }

    private void doWork() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);

    }

    private synchronized void increment() {
        count++;
    }
}
