package com.enjoyms.template;


public class Main {

    public static void main(String[] args) {


        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时: "+ (end-start) +"毫秒");

        // 如何计算 for 循环代码块的耗时，或者计算一个 方法的耗时。 通过模板设计模式实现

        /*
        *  设计一个计算耗时的模板
        * */

        Test test = new Test();
        System.out.println(test.getScheduleTime());

    }
}


abstract class TimeTemplate {
    // 获取执行的时间
    public long getScheduleTime(){
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        return end-start;
    }

    public abstract void code();
}

class Test extends TimeTemplate {

    @Override
    public void code() {

        for (int i = 0; i < 1000000; i++) {

            System.out.println(i);
        }

    }
}
