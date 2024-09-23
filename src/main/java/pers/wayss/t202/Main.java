package pers.wayss.t202;

import java.util.HashSet;
import java.util.Set;

/**
 * 数据结构：
 * 算法：
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    // 方法一：双指针（算法思路类似于链表是否有环）
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int slow = n;
        int fast = nextVal(n);
        while (fast != 1 && slow != fast) {
            slow = nextVal(slow);
            fast = nextVal(nextVal(fast));
        }
        return fast == 1;
    }

    // 方法二：哈希表存放计算过的数
    public boolean isHappy2(int n) {
        // set保存计算过的数，判断是否有环
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = nextVal(n);
        }
        return n == 1;
    }

    // 下一个数：每位的平方之和
    public int nextVal(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }
}