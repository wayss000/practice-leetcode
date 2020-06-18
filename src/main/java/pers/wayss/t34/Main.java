package pers.wayss.t34;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
        int target = 6;
        Solution solution = new Solution();
        int [] result = solution.searchRange(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = searchFirstLeft(nums, target);
        int right = searchLastRight(nums, target);
        int[] result = {left, right};
        return result;
    }

    private int searchLastRight(int[] nums, int target) {
        int result = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                result = mid;
                l = mid + 1;
            }
            if (nums[mid] < target){
                l = mid + 1;
            }
            if (nums[mid] > target){
                r = mid - 1;
            }
        }
        return result;
    }

    private int searchFirstLeft(int[] nums, int target) {
        int result = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                result = mid;
                r = mid - 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return result;
    }
}