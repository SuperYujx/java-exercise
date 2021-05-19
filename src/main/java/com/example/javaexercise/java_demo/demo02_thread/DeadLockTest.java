package com.example.javaexercise.java_demo.demo02_thread;

/**
 * 线程死锁
 */

public class DeadLockTest {
    public Object resourceA = new Object();
    public Object resourceB = new Object();


    public static void main(String[] args) throws InterruptedException {
        DeadLockTest deadLockExample = new DeadLockTest();
        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                synchronized(deadLockExample.resourceA) {
                    System.out.printf(
                            "[INFO]: %s get resourceA" + System.lineSeparator(),
                            Thread.currentThread().getName()
                    );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf(
                            "[INFO]: %s trying to get resourceB" + System.lineSeparator(),
                            Thread.currentThread().getName()
                    );
                    synchronized(deadLockExample.resourceB) {
                        System.out.printf(
                                "[INFO]: %s get resourceB" + System.lineSeparator(),
                                Thread.currentThread().getName()
                        );
                    }
                    System.out.printf(
                            "[INFO]: %s has done" + System.lineSeparator(),
                            Thread.currentThread().getName()
                    );
                }
            }
        };
        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                synchronized(deadLockExample.resourceB) {
                    System.out.printf(
                            "[INFO]: %s get resourceB" + System.lineSeparator(),
                            Thread.currentThread().getName()
                    );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf(
                            "[INFO]: %s trying to get resourceA" + System.lineSeparator(),
                            Thread.currentThread().getName()
                    );
                    synchronized(deadLockExample.resourceA) {
                        System.out.printf(
                                "[INFO]: %s get resourceA" + System.lineSeparator(),
                                Thread.currentThread().getName()
                        );
                    }
                    System.out.printf(
                            "[INFO]: %s has done" + System.lineSeparator(),
                            Thread.currentThread().getName()
                    );
                }
            }
        };
        Thread r = new Thread(runnableA);
        r.join();
        r.start();
        new Thread(runnableB).start();
    }
}
