package com.crystal.Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable<Long> {

    private static final int NTHREADS = 10;

    public static void main(String... args) {

        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
        List<Future<Long>> list = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            Callable<Long> worker = new MyCallable();
            Future<Long> submit = executor.submit(worker);
            list.add(submit);
        }
        long sum = 0;
        System.out.println(list.size());
        for (Future<Long> future : list) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sum);
        executor.shutdown();

    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (long i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
