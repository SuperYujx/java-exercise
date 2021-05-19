package com.example.javaexercise.java_demo.demo02_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
        System.out.println("add");
        lock.lock();
        try {
            count += n;
        } finally {
            System.out.println("count = " + count);
            System.out.println("add end");
            lock.unlock();
        }
    }

    public synchronized void add2(int n) {
        System.out.println("add2");
        count += n;
    }

    public synchronized void myPrint() {
        while (true) {
            System.out.println("myPrint");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();

        new Thread(() -> {
            reentrantLockTest.myPrint();

        }).start();

        new Thread(() -> {
            reentrantLockTest.add(1);
        }).start();

    }
}
