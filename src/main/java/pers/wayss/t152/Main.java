package pers.wayss.t152;

/**
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");

        int[] nums = new int[]{2, 3, -2, 4, -1};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(nums));
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int curMax = 1;
        int curMin = 1;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num, num);

            max = Math.max(curMax, max);
        }

        return max;
    }
}