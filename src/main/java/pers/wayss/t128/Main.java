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
            // （若num-1存在，表示当前 数 不是序列的第一个，较小的数肯定都会走下面的遍历，因此该判断可减少重复）。
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