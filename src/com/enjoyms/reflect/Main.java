package com.enjoyms.reflect;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {

        // 1. Object 类的 getClass() 方法
        Person person1 = new Person();
        Class clz1 = person1.getClass();

        // 2. 静态属性 class
        Class clz2 = Person.class;

        // 3. Class 类中的静态方法 forName()
        Class clz3 = Class.forName("com.enjoyms.reflect.Person");

        // 通过打印 hashCode 来判断是同一 Class 对象
        System.out.println(clz1.hashCode());
        System.out.println(clz2.hashCode());
        System.out.println(clz3.hashCode());

        // Class 类中静态方法 forName() 读取配置文件,直接写死文件

        String className = "com.enjoyms.reflect.Person";
        Class clz = Class.forName(className);

        // 通过读取 info.txt 文件内容
        FileReader fr = new FileReader("info.txt");
        BufferedReader br = new BufferedReader(fr);
        String className1 = br.readLine();
        Class clz11 = Class.forName(className1);

    }
}
