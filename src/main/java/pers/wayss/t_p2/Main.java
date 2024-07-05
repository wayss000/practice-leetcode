package pers.wayss.t_p2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * XXX N面编程题：
 * 给定初始整型列表list和线程数量n，要求:
 * - 使用n个线程按list顺序交替输出list中的值;
 * - list输出完成后，再分别输出每个线程各自输出过的列表;
 * - 最后输出字符串end;
 * (使用System.out.println函数输出结果)
 * <p>
 * 示例：
 * // 初始列表
 * List<Integer> list = Stream.iterate(0, k -> k + 1).limit(7).collect(Collectors.toList());
 * // 线程数量
 * int n= 3;
 * 针对以上初始参数，输出如下结果。
 * ```
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * [0, 3, 6]
 * [1, 4]
 * [2, 5]
 * end
 * ```
 * <p>
 * tips：线程写法(创建线程)、同步(Semaphore)、闭锁(CountDownLatch)
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("practice leetcode.");

        // 初始列表
        List<Integer> list = Stream.iterate(0, k -> k + 1).limit(7).collect(Collectors.toList());
        // 线程数量
        int n = 3;

        CountDownLatch cdt = new CountDownLatch(3);
        Semaphore semp = new Semaphore(1);
        AtomicInteger index = new AtomicInteger(0);


        List<TTT> TTTS = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TTTS.add(new TTT(cdt, semp, list, index));
        }

        for (TTT TTT : TTTS) {
            Thread thread = new Thread(TTT);
            thread.start();
        }

        System.out.println();
        cdt.await();
        TTTS.forEach(TTT -> {
            System.out.println(TTT.printList);
        });

        System.out.println("end");

    }
}

class TTT implements Runnable{
    // 记录打印过的数据
    public List<Integer> printList;
    // 共享数据
    private List<Integer> list;
    // 需要读取数的下标
    private AtomicInteger index;
    private CountDownLatch cdt;
    private Semaphore semp;

    TTT(CountDownLatch cdt, Semaphore semp, List<Integer> list, AtomicInteger index) {
        this.cdt = cdt;
        this.semp = semp;
        this.printList = new ArrayList<>();
        this.list = list;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            System.out.println("start-"+Thread.currentThread().getName());
            while (true) {
                // 获取信号量
                semp.acquire();
                if (index.get() >= list.size()) {
                    // 释放许可
                    semp.release();
                    break;
                }
                Integer x = list.get(index.get());
                // 打印
                System.out.println("threadName="+Thread.currentThread().getName());
                System.out.println(x);
                printList.add(x);
                // 活干完了，计数自增1
                index.addAndGet(1);
                // 释放许可
                semp.release();
                Thread.sleep(500);
            }
            System.out.println("end-"+Thread.currentThread().getName());
            cdt.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}