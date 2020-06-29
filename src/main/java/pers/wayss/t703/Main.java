package pers.wayss.t703;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.PriorityQueue;

/**
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String [] args){
        System.out.println("practice leetcode.");
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(k,arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums){
            this.add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k){
            queue.add(val);
        }else{
            if (queue.peek() < val){
                queue.poll();
                queue.add(val);
            }
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */