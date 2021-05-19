package com.example.javaexercise.java_demo.demo02_thread;

import java.util.*;

/**
 * wait和notify用于多线程协调运行：
 *
 * 在synchronized内部可以调用wait()使线程进入等待状态；
 *
 * 必须在已获得的锁对象上调用wait()方法；
 *
 * 在synchronized内部可以调用notify()或notifyAll()唤醒其他等待线程；
 *
 * 必须在已获得的锁对象上调用notify()或notifyAll()方法；
 *
 * 已唤醒的线程还需要重新获得锁后才能继续执行。
 */


public class WaitNotifyTest {
    public static void main(String[] args) throws InterruptedException {
        int num = 0;
        TaskQueue taskQueue = new TaskQueue();
        Thread thread = new Thread(()->{
            while (true){
                try {
                    System.out.println("taskQueue.getTask() = " + taskQueue.getTask());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        //thread.setDaemon(false);
        thread.start();


        for (int i = 0; i < 5; i++) {
            taskQueue.addTask(String.valueOf(i));
            Thread.sleep(100);
        }



    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        // 唤醒线程
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            // 释放线程
            this.wait();
        }
        return queue.remove();
    }
}