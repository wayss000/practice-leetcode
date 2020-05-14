package pers.wayss.t136;

/**
 * 136. 只出现一次的数字
 * <url>https://leetcode-cn.com/problems/single-number/</url>
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums){
            result ^= i;
        }
        return result;
    }
}