package com.company.Threading;

public class PollingExample {

    public static void main(String ... args) throws InterruptedException {

        final PC pc = new PC();

        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }



}

