package pers.wayss.t1;

/**
 * 1. 两数之和
 * <url>https://leetcode-cn.com/problems/two-sum/</url>
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
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                result[1] = j;
                if (nums[result[0]] + nums[result[1]] == target) {
                    return result;
                }
            }
        }
        return result;
    }
}