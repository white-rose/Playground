package com.company.Threading;

public class TheRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("thread 2 going to sleep for 5000");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Thread2 has been interrupted");
        }
    }
}

class TheRunnableTester implements Runnable {

    @Override
    public void run() {

    }

    public static void main (String ... args) throws InterruptedException {

       TheRunnableTester obj = new TheRunnableTester();
       TheRunnable obj2 = new TheRunnable();

       Thread thread1 = new Thread(obj);
       Thread thread2 = new Thread(obj2);

       thread1.start();
       thread2.start();

       ClassLoader loader = thread1.getContextClassLoader();
       Thread thread3 = new Thread(new TheRunnable());

       System.out.println(Thread.activeCount());
       thread1.checkAccess();

       Thread t = Thread.currentThread();
       System.out.println(t.getName());

       System.out.println("Thread1 name: "+ thread1.getName());
       System.out.println("Thread1 ID: "+ thread1.getId());

       System.out.println("Priority of thread1 = " + thread1.getPriority());

       System.out.println(thread1.getState());

       thread2 = new Thread(obj2);
       thread2.start();
       thread2.interrupt();
       System.out.println("Is thread2 interrupted? " + thread2.isInterrupted());
       System.out.println("Is thread2 alive? " + thread2.isAlive());

       thread1 = new Thread(obj);
       thread1.setDaemon(true);
       System.out.println("Is thread1 a daemon thread" + thread1.isDaemon());
       System.out.println("Is thread1 interrupted? " + thread1.isInterrupted());



    }

}
