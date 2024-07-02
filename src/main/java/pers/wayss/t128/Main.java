package pers.wayss.t128;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/
 *
 * 数据结构：数组
 * 算法：哈希表
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            // !set.contains(num - 1) 判断，能够去除重复的判断
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curMax = 0;
                while (set.contains(curNum)) {
                    curNum++;
                    curMax++;
                }
                max = Math.max(curMax, max);
            }
        }
        return max;
    }
}