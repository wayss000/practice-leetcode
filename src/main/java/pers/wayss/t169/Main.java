package pers.wayss.t169;

/**
 * 169. 多数元素
 * https://leetcode.cn/problems/majority-element/
 * <p>
 * 数据结构：数组
 * 算法：遍历，记录最大数
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    // 题解思路：https://leetcode.cn/problems/majority-element/solutions/2362000/169-duo-shu-yuan-su-mo-er-tou-piao-qing-ledrh/?envType=study-plan-v2&envId=top-interview-150
    public int majorityElement(int[] nums) {
        int x = 0;
        // 投票计次，假设当前数为众数
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }

            if (num == x) {
                votes++;
            } else {
                votes--;
            }
        }
        return x;
    }
}