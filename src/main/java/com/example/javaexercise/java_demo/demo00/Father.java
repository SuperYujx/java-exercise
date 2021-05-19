package com.example.javaexercise.java_demo.demo00;

public class Father {
    Father(){
        System.out.println("父类无参构造方法");
    }

    Father(String str){
        System.out.println("父类有参构造方法");
    }

    int age = 1;
    static String name = "father";


    public int getAge(){
        System.out.println("father-getAge");
        return age;
    }

    public static String getName(){
        System.out.println("father-getName");
        return name;
    }
}
