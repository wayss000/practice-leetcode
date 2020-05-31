package pers.wayss.t53;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int curMax = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            max = Math.max(curMax, max);
        }
        return max;
    }
}