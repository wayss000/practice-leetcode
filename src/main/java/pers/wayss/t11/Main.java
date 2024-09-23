package pers.wayss.t11;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/description/
 * <p>
 * 数据结构：数组
 * 算法：双指针
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] > height[j]) {
                result = Math.max(result, height[j] * (j - i));
                j--;
            } else {
                result = Math.max(result, height[i] * (j - i));
                i++;
            }
        }
        return result;
    }
}