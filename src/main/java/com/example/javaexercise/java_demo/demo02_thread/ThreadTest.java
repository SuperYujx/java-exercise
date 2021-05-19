package com.example.javaexercise.java_demo.demo02_thread;

class MyThread01 implements Runnable {
    private String name;

    MyThread01() {
    }

    MyThread01(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "运行：" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread02 extends Thread {
    private String name;

    MyThread02() {
    }

    MyThread02(String name) {
        this.name = name;
    }

    MyThread02(Runnable target, String name) {
        super(target, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "运行：" + i);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread03 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "进入run方法");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "sleep结束");
            e.printStackTrace();
        }
    }
}

class MyThread04 implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "在运行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread05 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在运行" + i);
            if (2 == i) {
                System.out.println("线程礼让：");
                Thread.yield();

            }
        }
    }
}

class MyThread06 implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        run02();
    }

    public void run01() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出：" + ticket--);
            }
        }
    }

    public void run02() {
        for (int i = 0; i < 10; i++) {
            // 通过 synchronized 对当前对象进行同步，如果该线程对当前对象的操作没有执行完时，不会跳到下一个线程
            synchronized (this) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出：" + ticket--);
                }else if(ticket == 2){
                    Thread.yield();
                }
            }

        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
//        MyThread01 myThread01 = new MyThread01("myThread01");
//        Thread thread01 = new Thread(myThread01, "myThread01");
//        thread01.start();
//
//        MyThread02 myThread02 = new MyThread02();
//        myThread02.start();

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//        MyThread03 myThread03 = new MyThread03();
//        Thread thread03 = new Thread(myThread03, "myThread03");
//        thread03.start();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        // interrupt用来中断线程状态
//        thread03.interrupt();

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // 守护线程：守护线程是指为其他线程服务的线程。在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
//        MyThread04 myThread04 = new MyThread04();
//        Thread thread04 = new Thread(myThread04,"myThread04");
//        // setDaemon设置为true后，主线程结束后，子线程也停止运行
//        thread04.setDaemon(true);
//        thread04.start();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName()+"在运行");
//        }

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // 线程优先级
//        Thread thread05 = new Thread(new MyThread01(),"A");
//        Thread thread06 = new Thread(new MyThread01(),"B");
//        Thread thread07 = new Thread(new MyThread01(),"C");
//        thread05.setPriority(Thread.MIN_PRIORITY);
//        thread06.setPriority(Thread.NORM_PRIORITY);
//        thread07.setPriority(Thread.MAX_PRIORITY);
//        thread05.start();
//        thread06.start();
//        thread07.start();

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // 线程的礼让
//        Thread thread08 = new Thread(new MyThread05(), "A");
//        Thread thread09 = new Thread(new MyThread05(), "B");
//        thread08.start();
//        thread09.start();

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // 资源同步
        MyThread06 myThread06 = new MyThread06();
        Thread thread10 = new Thread(myThread06, "A");
        Thread thread11 = new Thread(myThread06, "B");
        Thread thread12 = new Thread(myThread06, "C");
        thread10.start();
        thread11.start();
        thread12.start();

    }
}
