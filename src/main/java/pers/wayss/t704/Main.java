package pers.wayss.t704;

/**
 * 704. 二分查找
 * https://leetcode.cn/problems/binary-search/description/
 *
 * 数据结构：数组
 * 算法：二分查找
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        Solution solution = new Solution();
        int[] nums = {5};
        int target = 5;
        int search = solution.search(nums, target);
        System.out.println(search);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}