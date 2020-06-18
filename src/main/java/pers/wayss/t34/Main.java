package pers.wayss.t34;

/**
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
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
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

        }
        return -1;
    }

    private int searchFirstLeft(int[] nums, int target) {
        return -1;
    }
}