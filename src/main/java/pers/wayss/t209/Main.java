package pers.wayss.t209;

/**
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
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
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int minValue = Integer.MAX_VALUE;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s){
                minValue = Math.min(minValue, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minValue;
    }
}