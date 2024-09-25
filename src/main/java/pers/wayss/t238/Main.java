package pers.wayss.t238;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/description/
 * <p>
 * 数据结构：数组
 * 算法：前缀乘积、后缀乘积
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 计算前缀乘积
        int[] res = new int[nums.length];
        // 默认第一个数的前缀乘积为1
        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            // 计算下一个数的pre（前两个数的乘积）
            pre = pre * nums[i];
        }
        // 计算后缀乘积
        // 默认最后一个数的后缀乘积为1
        int post = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] = post * res[j];
            // 计算上一个数的post（后两个数的乘积）
            post = nums[j] * post;
        }
        return res;
    }
}