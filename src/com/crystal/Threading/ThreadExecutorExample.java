package com.crystal.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorExample {

    private static final int NTHREADS = 10;

    public static void main (String [] args) {

        //Executor example
        try {
            ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
            for (int i = 0; i < 500; i++) {
                Runnable worker = new MyRunnable(10000000L + i);
                executor.execute(worker);
            }

            executor.shutdown();
            ;

            executor.awaitTermination(100, TimeUnit.MINUTES);
            System.out.println("Finished all threads");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }



    }

}

class MyRunnable implements Runnable {

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
