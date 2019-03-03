package com.enjoyms.study;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    class MyRunnable implements Runnable {
        private Semaphore semaphore;
        private int user;

        public MyRunnable(Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("用户 "+ user + "开始操作");
                Thread.sleep((long) (Math.random() * 100));
                System.out.println("用户 "+ user + "正在操作");
                Thread.sleep((long) (Math.random() * 100));
                System.out.println("用户 "+ user + "已离开");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void executeTask() {
        // 定义信号量个数
        final Semaphore s = new Semaphore(2);
        ExecutorService threadPoll = Executors.newCachedThreadPool();

        // 模拟 20 个人执行任务
        for (int i = 0; i < 20; i++) {
            threadPoll.execute(new MyRunnable(s, i));
        }
        threadPoll.shutdown();
    }
    public static void main(String[] args) {

        SemaphoreDemo sd = new SemaphoreDemo();
        sd.executeTask();
    }
}

