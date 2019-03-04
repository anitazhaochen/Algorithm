package com.enjoyms.study;

import java.lang.reflect.Field;

public class SwapTwoNum {
    private static class Cache {
        static final Integer[] e = new Integer[10];
    }
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println("a:"+a+"b:"+b);
        swap(a, b);
        System.out.println("a:"+a+"b:"+b);

        Integer c = 1111;
        Integer d = 1111;
        System.out.println(c==d);
//        final Integer[] e = new Integer[10];
        Cache.e[5] = 3;
        Integer f = Cache.e[5];
        System.out.println(f == Cache.e[5]);
        Cache.e[5] = 4;
        System.out.println(f);
        Integer i = 1;
        System.out.println(i);

        Result();
    }

    public static void swap(Integer a, Integer b) {

        int temp = a.intValue();
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(a, b);
            field.setInt(b, temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Result() {
        Integer a = 10;
        Integer b = 10;
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.setInt(b, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println(b);
    }
}
