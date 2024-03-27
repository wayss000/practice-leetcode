package pers.wayss.t167;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    // 题目要求的索引是从 1 开始
                    return new int[]{left + 1, right + 1};
                }
                if (sum < target) {
                    left++;
                }
                if (sum > target) {
                    right--;
                }
            }
            return new int[]{-1, -1};
        }
    }
}

