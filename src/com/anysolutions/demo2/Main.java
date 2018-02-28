package com.anysolutions.demo2;

class Runner implements Runnable {

    final private int id;

    Runner(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread #" + this.id + ": " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner(1));
        Thread t2 = new Thread(new Runner(2));

        System.out.println("demo2.java");

        t1.start();
        t2.start();
    }
}
