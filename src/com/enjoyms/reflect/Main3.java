package com.enjoyms.reflect;

import java.lang.reflect.Field;

public class Main3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 通过反射获取成员变量（属性）并使用

        // 1. 获取字节码对象
        Class clz = Person.class;

        // 2. 使用 getField() 只可以获取公共字段（public 字段） age 字段。
        Field ageFiled = clz.getField("age");
        System.out.println(ageFiled);

        //3. 通过反射给字段赋值
        Person person = new Person();
        ageFiled.set(person,30);
        System.out.println(person);

        // 4. 获取私有属性
        Field nameField = clz.getDeclaredField("name");
        System.out.println(nameField);

        //5. 通过反射给私有属性赋值
        nameField.setAccessible(true);
        nameField.set(person,"小红");
        System.out.println(person);

        // 如果 Person 类没有 get、set 方法，依旧可以利用反射进行赋值

        //6. 通过反射获取私有属性的值
        Object value = nameField.get(person);
        System.out.println(value);


    }
}
