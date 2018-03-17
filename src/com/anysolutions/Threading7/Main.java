package com.anysolutions.Threading7;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(final String args[]) throws InterruptedException {

        Thread t1 = new Thread(() -> producer());

        Thread t2 = new Thread(() -> consumer());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

    private static void producer() {
        final Random random = new Random();
        while (true) {
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer() {
        Random random = new Random();

        while (true) {
            try {
                Thread.sleep(100);

                if(random.nextInt(10) == 0) {
                    final Integer value = queue.take();
                    System.out.println("Taken value: " + value + "; Queue size is: "+ queue.size());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
