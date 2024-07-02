package pers.wayss.t162;

/**
 * 162. 寻找峰值
 * https://leetcode.cn/problems/find-peak-element/description/
 *
 * 数据结构：数据
 * 算法：二分法用nums[mid]和nums[mid+1]对比
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}