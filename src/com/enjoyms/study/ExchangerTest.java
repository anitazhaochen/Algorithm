package com.enjoyms.study;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

    public static void main(String[] args) {
        // 交换器，交换 String 类型数据
        Exchanger<String> exchanger = new Exchanger<String>();

        ExecutorService threadPoll = Executors.newCachedThreadPool();

        threadPoll.execute(new Runnable() {
            @Override
            public void run() {
                // 交换 数据1 apple
                String content = null;
                try {
                    content = exchanger.exchange("apple");
                    System.out.println("用 apple 交换了,得到了 "+ content);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPoll.execute(new Runnable() {
            @Override
            public void run() {
                String content = null;
                try {
                    content = exchanger.exchange("orange");
                    System.out.println("用 orange 交换, 得到了 "+ content);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
