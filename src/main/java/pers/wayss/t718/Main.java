package pers.wayss.t718;

/**
 * 718. 最长重复子数组
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
 *
 * 数据结构：数组
 * 算法1：动态规划dp[nums1.length][nums2.length]
 * 算法2：滑动窗口
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");

        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(solution.findLength1(nums1, nums2)); // 输出: 3

        int[] nums1_2 = {0, 0, 0, 0, 0};
        int[] nums2_2 = {0, 0, 0, 0, 0};
        System.out.println(solution.findLength1(nums1_2, nums2_2)); // 输出: 5

    }
}

class Solution {

    // 动态规划写法
    /*
    示例
假设 nums1 = [1, 2, 3, 2, 1] 和 nums2 = [3, 2, 1, 4, 7]，我们来看看 dp 表是如何填充的：
    0	1	2	3	4	5
0	0	0	0	0	0	0
1	0	0	0	1	0	0
2	0	0	1	0	0	0
3	0	1	0	0	0	0
4	0	0	2	0	0	0
5	0	0	0	3	0	0
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }

    // 双指针写法
    public int findLength1(int[] nums1, int[] nums2) {
        int maxLength = 0;

        // nums1 固定，nums2 滑动
        for (int i = 0; i < nums1.length; i++) {
            int len = Math.min(nums1.length - i, nums2.length);
            int maxLen = maxLength(nums1, nums2, i, 0, len);
            maxLength = Math.max(maxLength, maxLen);
        }

        // nums2 固定，nums1 滑动
        for (int j = 0; j < nums2.length; j++) {
            int len = Math.min(nums1.length, nums2.length - j);
            int maxLen = maxLength(nums1, nums2, 0, j, len);
            maxLength = Math.max(maxLength, maxLen);
        }

        return maxLength;
    }

    private int maxLength(int[] nums1, int[] nums2, int start1, int start2, int len) {
        int maxLen = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[start1 + i] == nums2[start2 + i]) {
                k++;
                maxLen = Math.max(maxLen, k);
            } else {
                k = 0;
            }
        }
        return maxLen;
    }
}
