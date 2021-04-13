package com.example.javaexercise.demo01;

public class OutterClass {
    int a = 1;
    static int b = 2;
    OutterClass(){
        System.out.println("OutterClass 的构造方法");
    }

    class InnerClass01{
        InnerClass01(){
            System.out.println("InnerClass01 构造方法");
        }

        void sayHi01(){
            System.out.println("InnerClass01.sayHi01");
        }
    }

    void method01(){
        InnerClass01 innerClass01 = new InnerClass01();
        innerClass01.sayHi01();
    }

    static void method02(){
        InnerClass01 innerClass01 = new OutterClass().new InnerClass01();
        innerClass01.sayHi01();
    }

    static class InnerClass02{
        InnerClass02(){
            System.out.println("InnerClass02 构造方法");
        }

        static void sayHi02(){
            System.out.println("InnerClass02.sayHi02");
        }
    }

    void method03(){
        int a = 3;
        class InnerClass03{
            InnerClass03(){
                System.out.println("InnerClass03 构造方法");
            }

            void printOutterClass01(){
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                System.out.println("OutterClass.this.a = " + OutterClass.this.a);
            }
        }

        InnerClass03 innerClass03 = new InnerClass03();
        innerClass03.printOutterClass01();
    }
}

class Test{
    public static void main(String[] args) {
        OutterClass.InnerClass01 innerClass01 = new OutterClass().new InnerClass01();
        innerClass01.sayHi01();

        OutterClass.InnerClass02 innerClass02 = new OutterClass.InnerClass02();
        OutterClass.InnerClass02.sayHi02();

        OutterClass outterClass = new OutterClass();
        outterClass.method03();

    }
}
