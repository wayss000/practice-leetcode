package pers.wayss.t198;

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
        System.out.println(solution.rob(nums));
    }
}

class Solution {
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
}