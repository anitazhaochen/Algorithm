package com.enjoyms.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 通过反射越过泛型检查

        // 1. 声明泛型集合
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        // list.add("hello") 会报错

        // 通过反射向集合添加字符串
        // 2.1 获取字节码对象 （Class）
        Class clz = list.getClass();

        // 2.2 通过反射获取方法
        Method method = clz.getMethod("add", Object.class);

        // 2.3 调用方法
        method.invoke(list,"hello");
        System.out.println(list);

        // 输出  [1, 2, 3, hello]
    }
}
