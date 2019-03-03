package com.enjoyms.study;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

//        CyclicBarrier cb = new CyclicBarrier(3);
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("人员全部到齐，各自拍照留恋");
                try {
                    Thread.sleep((long) (Math.random()* 10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        // 线程池
        ExecutorService threadPoll = Executors.newCachedThreadPool();

        // 建立3个线程（用户）
        for (int i = 0; i < 3; i++) {
            final int user = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // 模拟每个人来的时间各不相同
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(user + "到达聚餐地点,当前已有" + (cb.getNumberWaiting()+1) + "  人到达");
                        cb.await(); // 阻塞
                        // 开始吃饭
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("人员全部到齐,开始吃饭");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("吃完饭，准备回家");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPoll.execute(runnable);

        }
        threadPoll.shutdown();
    }
}
