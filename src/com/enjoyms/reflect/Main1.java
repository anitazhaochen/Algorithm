package com.enjoyms.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
// 如果是 java.lang 包内的类，不需要导入，直接可以使用。 但是如果是它的内部的其他包，则需要导入。

public class Main1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 通过反射获取带参数构造方法并使用
        /*
        *
        * 反射： 用于获取类的方法和属性
        * 1. 先要获取字节码对象
        * 2. 通过字节码对象的 getConstructor() 方法
        * */

        // 1. 获取字节码对象
        Class clz = Person.class;

        // 2.1 获取构造方法
        Constructor c1 = clz.getConstructor();

        // 2.2 通过构造方法创建对象
        Person person = (Person) c1.newInstance();
        System.out.println(person);

        // 2.3 获取有参构造方法,参数写数据类型，如 String.class、double.class 等等
        Constructor c2 = clz.getConstructor(String.class);
        Person person1 = (Person) c2.newInstance("小明"); // 相当于调用 new Person("小明")
        System.out.println(person1);

    }
}
