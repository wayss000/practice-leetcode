package pers.wayss.t198;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        int[] nums = new int[]{2,7,9,3,1};
        Solution solution = new Solution();
        System.out.println(solution.rob2(nums));
    }
}

class Solution {
    // 动态规划算法
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //当只有一个元素时
        if (nums.length == 1) {
            return nums[0];
        }
        //当只有两个元素时
        nums[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return nums[1];
        }
        //当有三个以上的元素时，动态规划方程：dp[i] = Max(dp[i-1], dp[i-2]+nums[i])
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }

        return nums[nums.length - 1];
    }

    // 尝试用回溯递归
    public int rob1(int[] nums) {
        return backtrace(nums, nums.length - 1);
    }

    private int backtrace(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        // 选择不偷当前房屋，最大金额为 robFrom(nums, i - 1)
        // 选择偷当前房屋，最大金额为 nums[i] + robFrom(nums, i - 2)
        return Math.max(backtrace(nums, i - 1), nums[i] + backtrace(nums, i - 2));
    }

    // 下面是对rob1的改进算法，用了memo数组缓存计算过的数据
    public int rob2(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robFrom(nums, nums.length - 1, memo);
    }

    private int robFrom(int[] nums, int i, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        memo[i] = Math.max(robFrom(nums, i - 1, memo), nums[i] + robFrom(nums, i - 2, memo));
        return memo[i];
    }
}