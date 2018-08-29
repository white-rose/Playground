package com.crystal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    private static final int NTHREADS = 10;

    public static void main(String [] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);

        for (int i = 0; i < 500; i++) {
            Runnable worker = new MyRunnable(10000000L + i);
            executor.execute(worker);
        }

        executor.shutdown();

    }

    public static class MyRunnable implements Runnable {
        private final long countUntil;

        MyRunnable(long countUntil) {
            this.countUntil = countUntil;
        }

        @Override
        public void run() {
            long sum = 0;
            for (long i = 1; i < countUntil; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

}
