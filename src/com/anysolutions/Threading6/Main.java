package com.anysolutions.Threading6;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
    final CountDownLatch latch;

    Processor(CountDownLatch latch) {
        System.out.println("Started");
        this.latch = latch;
    }


    @Override
    public void run() {
        latch.countDown();
    }
}


public class Main {


    public static void main(String args[]) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.submit(new Processor(latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed");
    }


}
