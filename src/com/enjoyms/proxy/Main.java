package com.enjoyms.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        // 1. 创建对象
        UserServiceImpl usi = new UserServiceImpl();

        //2. 创建代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(usi.getClass().getClassLoader(),
                usi.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method);
                        System.out.println("权限检验.....");

                        // 拦截了方法
                        Object returnObj = method.invoke(usi, args);

                        System.out.println("日志记录");
                        return returnObj;
                    }
                });

        proxy.registerUser();
        proxy.deleteUser();

    }
}

interface UserService{

    public void registerUser();
    public void deleteUser();

}

class UserServiceImpl implements UserService {

    @Override
    public void registerUser() {

        System.out.println("注册一个用户");

    }

    @Override
    public void deleteUser() {

        System.out.println("删除一个用户");

    }
}
