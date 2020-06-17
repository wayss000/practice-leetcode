package pers.wayss.t33;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
//        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{3,1};
        int target = 1;
        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
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
            //如果mid左边有序
            if (nums[left] <= nums[mid]) {
                //target在左边的有序子数组中
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                    //target在右边
                } else {
                    left = mid + 1;
                }
                //否则右边有序
            } else {
                //target在右边的有序子数组中
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                    //target在左边
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}