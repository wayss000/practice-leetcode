package pers.wayss.t912;

import java.util.Arrays;

/**
 * 912.排序数组
 * https://leetcode.cn/problems/sort-an-array/description/
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        // 直接调API，采用了：双轴快速排序(Dual Pivot Quicksort)
        Arrays.sort(nums);
        return nums;
    }
    // 方案零：冒泡或选择。时间复杂度O(n^2)，空间复杂度O(1)
    public int[] sort0(int[] nums) {
        return null;
    }

    // 方案一：快排。时间复杂度O(nlogn)，空间复杂度O(h),h为快速排序递归调用的层数
    public int[] sort1(int[] nums) {
        return null;
    }

    // 方案二：堆排。时间复杂度O(nlogn)，空间复杂度O(1)
    public int[] sort2(int[] nums) {
        return null;
    }

    // 方案三：归并排序，时间复杂度O(nlogn)，空间复杂度O(n)
    public int[] sort3(int[] nums) {
        return null;
    }
}