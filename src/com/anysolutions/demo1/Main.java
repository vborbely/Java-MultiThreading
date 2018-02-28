package com.anysolutions.demo1;

class Runner extends Thread {
    final int id;

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

        Runner runner1 = new Runner(1);
        runner1.start();

        Runner runner2 = new Runner(2);
        runner2.start();
    }


}
