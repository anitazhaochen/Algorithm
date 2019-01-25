package com.enjoyms.reflect;

import java.lang.reflect.Field;

public class Main4 {
    // 通用方法，设置对象属性

    // 通过反射给私有属性赋值
    public static void setFieldValue(Object obj, String fieldName, String fieldValue){
        // 1. 获取字节码
        Class clz = obj.getClass();

        try {
            // 2. 获取属性 Field
            Field field = clz.getDeclaredField(fieldName);

            //3. 设置权限
            field.setAccessible(true);

            //4. 赋值属性
            field.set(obj, fieldValue);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
