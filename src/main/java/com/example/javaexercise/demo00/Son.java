package com.example.javaexercise.demo00;

public class Son extends Father {
    Son(){
        super("str");
        System.out.println("子类无参构造方法");
    }

    int age = 2;
    static String name = "son";

    @Override
    public int getAge(){
        System.out.println("son-getAge");
        return age;
    }

    // 静态方法不可以重写
    public static String getName(){
        System.out.println("son-getName");
        return name+"son";
    }
}

class SonTest {
    public static void main(String[] args) {
        // 父类引用指向子类变量，向上转型
        Father father = new Son();
        Son son = new Son();

        // 子类引用指向父类变量，向下转型，会报错
        // Son son1 = new Father();

        // 安全的进行转化
        /*Father father1 = new Son();
        if(father1 instanceof Son){
            Son son1 = (Son)father1;
            System.out.println("son1.getAge() = " + son1.getAge());
        }*/

        // 成员变量和静态方法：编辑看左边，执行看左边
        System.out.println("静态成员变量");
        System.out.println("father.name = " + Father.name);
        System.out.println("son.name = " + Son.name);
        System.out.println("非静态成员变量");
        System.out.println("father.age = " + father.age);
        System.out.println("son.age = " + son.age);
        System.out.println("静态方法");
        System.out.println("father.getName() = " + Father.getName());
        System.out.println("son.getName() = " + Son.getName());

        // 非静态方法：编译看左边，执行看右边
        System.out.println("非静态方法");
        System.out.println("father.getAge() = " + father.getAge());
        System.out.println("son.getAge() = " + son.getAge());
    }

    void lambdaTest() {
        int n1 = 10;
        int n2 = 5;
        // 打印加法计算结果
        display((a, b) -> {
            return a + b;
        }, n1, n2);
        // 打印减法计算结果
        display((a, b) -> a - b, n1, n2);

    }

    /**
     * 打印计算结果
     *
     * @param calc Lambda表达式
     * @param n1   操作数1
     * @param n2   操作数2
     */
    public static void display(Calculable calc, int n1, int n2) {
        System.out.println(calc.calculateInt(n1, n2));
    }


}

// 可计算接口
@FunctionalInterface
interface Calculable {
    // 计算一个int数值
    int calculateInt(int a, int b);
}
