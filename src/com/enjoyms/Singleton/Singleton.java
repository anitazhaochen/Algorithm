package com.enjoyms.Singleton;

public class Singleton {

/*

  饿汉法，就是在第一次引用该类的时候创建对象实例，而不管实际是否需要创建
  优点： 编写简单
  缺点： 无法做到延迟对象创建。我们很多时候都希望对象可以尽可能的延迟加载，从而减少负载。
 */
    private static Singleton instance = new Singleton();

    private Singleton(){};

    public static Singleton getInstance() {
        return instance;
    }
}

class Singleton1 {

    /*
    * 单线程写法
    * 这种方法实现了延迟加载，但是 线程不安全
    * */
    private static Singleton1 singleton = null;
    private Singleton1() {}
    public static Singleton1 getSingleton1() {
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}


class Singleton2 {

    /*
     * 多线程写法
     * 双重检查锁
     * new 的情况非常少，这样就可以提升并发。
     * volatile 关键字有两层语义：
     * 1. 可见性，是指一个线程中对该变量的修改会马上由工作内存写回主内从，所以会马上反应在其他线程的读取操作中
     * 2. 禁止指令重排序优化。 在单线程中没什么问题，然而一旦引入多线程，这种乱序可能导致严重问题。volatile 关键字就可以从语义上解决这个问题
     * 缺点：
     * 都需要额外的工作来实现序列化，否则每次反序列化一个序列化的对象时候都会创建一个新的实例
     * 可以通过反射强行调用我们的私有构造器 （如果避免这种情况，可以修改构造器，让它在创建第二个实例的时候抛出异常）
     * */
    private static volatile Singleton2 singleton = null;
    private Singleton2() {}
    public static Singleton2 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton2.class) {
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }
}

class Singleton3 {
    /*
    * 既可以延迟加载，又可以保证线程安全的写法
    * 由于静态内部类只会被加载一次，所以是线程安全的， 又避免了静态实例在 Singleton 类加载的时候创建对象
    * 缺点：
    * 都需要额外的工作来实现序列化，否则每次反序列化一个序列化的对象时候都会创建一个新的实例
    * 可以通过反射强行调用我们的私有构造器 （如果避免这种情况，可以修改构造器，让它在创建第二个实例的时候抛出异常）
    */
    private static class Holder {
        private static Singleton3 singleton = new Singleton3();
    }

    private Singleton3(){}

    public static Singleton3 getSingleton() {
        return Holder.singleton;
    }
}

enum Singleton4 {
    INSTANCE;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

/*
* 总结：
* 当一个类的对象只需要或者只有一个时，考虑单例模式
* 如果一个类的实力应该在 JVM 初始化时被创建出来，应该考虑使用饿汉式单例
* 如果一个类的实力不需要预先被创建，也许这个类的实例不一定能用得上，或者创建过程比较耗时，应该考虑懒汉单例
* 在使用懒汉单例的时候，应该考虑到线程安全性问题。
* */