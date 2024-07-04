package pers.wayss.t_p2;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// chatgpt 给的答案
public class ThreadedOutput {
    public static void main(String[] args) throws InterruptedException {
        // 初始列表
        List<Integer> list = Stream.iterate(0, k -> k + 1).limit(7).collect(Collectors.toList());
        // 线程数量
        int n = 3;

        // 线程输出记录
        List<List<Integer>> threadOutputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            threadOutputs.add(new ArrayList<>());
        }

        Lock lock = new ReentrantLock();
        Condition[] conditions = new Condition[n];
        for (int i = 0; i < n; i++) {
            conditions[i] = lock.newCondition();
        }

        // 共享状态
        int[] currentIndex = {0};
        int[] currentThread = {0};

        // 创建和启动线程
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final int threadIndex = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "::start");
                    while (true) {
                        lock.lock();
                        try {
                            System.out.println(Thread.currentThread().getName() + "::11111");
                            while (currentThread[0] != threadIndex) {
                                System.out.println(Thread.currentThread().getName() + "::222");
                                // 等待其他线程唤醒
                                conditions[threadIndex].await();
                            }
                            System.out.println(Thread.currentThread().getName() + "::333");
                            if (currentIndex[0] >= list.size()) {
                                // signal 唤醒一个其他的等待状态的线程
                                {
                                    currentIndex[0]++;
                                    currentThread[0] = (currentThread[0] + 1) % n;
                                    conditions[currentThread[0]].signal();
                                }
                                break;
                            }
                            int value = list.get(currentIndex[0]);
                            System.out.println(Thread.currentThread().getName() + "===" + value);
                            threadOutputs.get(threadIndex).add(value);
                            // signal 唤醒一个其他的等待状态的线程
                            {
                                currentIndex[0]++;
                                currentThread[0] = (currentThread[0] + 1) % n;
                                conditions[currentThread[0]].signal();
                            }
                        } finally {
                            lock.unlock();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "::end");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads.add(thread);
            thread.start();
        }

        // 等待所有线程完成
        for (Thread thread : threads) {
            thread.join();
        }

        // 输出每个线程各自输出的列表
        for (List<Integer> output : threadOutputs) {
            System.out.println(output);
        }

        // 输出字符串"end"
        System.out.println("end");
    }
}
