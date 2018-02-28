package com.anysolutions.demo4;


import java.util.Scanner;

class Processor extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {

        while (running) {
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }

}

public class Main {
    public static void main (String args[]) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press Enter to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();

    }


}
