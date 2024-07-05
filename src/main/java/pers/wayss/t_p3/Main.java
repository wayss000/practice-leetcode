package pers.wayss.t_p3;

/**
 * XX 编程题：给你一个数组，如[3,3,5,5,6,9,9]，都是成对出现，但有一个数字只有一个，请你找出来。
 *
 * 数据结构：数组
 * 算法1：双指针
 * 算法2：二分法
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        int[] nums = {9,9,6,5,5};
        Solution solution = new Solution();
        int unique = solution.func(nums);
//        int unique = solution.findUnique(nums);
        System.out.println("The unique number is: " + unique);
    }
}

class Solution {
    // 双指针，时间复杂度O(n)
    public int func(int nums[]) {
        int first = 0;
        int second = 1;
        while (second < nums.length) {
            if (nums[first] != nums[second]) {
                return nums[first];
            }
            first = first + 2;
            second = second + 2;
        }
        return -1;
    }

    // 二分法实现，时间复杂度O(logN)
    public int findUnique(int[] nums) {
        // 如果数组长度为偶数，直接返回 -1
        if (nums.length % 2 == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 如果 mid 是奇数，减一使其变成偶数。这是因为我们希望 mid 和 mid + 1 形成一对进行比较
            if (mid % 2 == 1) {
                mid--;
            }

            // 如果 nums[mid] 等于 nums[mid + 1]，说明 mid 和 mid + 1 形成了一对，唯一的数字在 mid 右边。因此，我们将 left 更新为 mid + 2
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // 如果 nums[mid] 不等于 nums[mid + 1]，说明唯一的数字在 mid 左边或就是 mid 位置。因此，我们将 right 更新为 mid
                right = mid;
            }
        }

        // left should be at the unique number
        return nums[left];
    }
}