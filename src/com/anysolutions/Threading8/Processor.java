package com.anysolutions.Threading8;

import java.util.Scanner;

public class Processor {

    public void produce() throws InterruptedException{
        synchronized (this) {
            System.out.println("Producer thread running ...");
            wait();
            System.out.println("Resumed.");

        }

    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);


        synchronized (this) {
            System.out.println("Waiting for the return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();  // notifies all the threads, with are locked on the 'this' object
            Thread.sleep(5000); //only after this time elapsed, the 'this' lock is released and the next thread can run
        }

    }
}
