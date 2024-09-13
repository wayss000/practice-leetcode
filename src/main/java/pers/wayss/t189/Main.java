package pers.wayss.t189;

/**
 * 189. 轮转数组
 * https://leetcode.cn/problems/rotate-array/description/
 * <p>
 * 数据结构：数组
 * 算法：旋转数组
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // 处理 k 大于 n 的情况

        // 反转整个数组
        reverse(nums, 0, n - 1);
        // 反转前 k 个元素
        reverse(nums, 0, k - 1);
        // 反转剩余的 n-k 个元素
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}