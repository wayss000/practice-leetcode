package pers.wayss.t55;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
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
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = maxIndex < nums[i] + i ? nums[i] + i : maxIndex;
        }
        return true;
    }
}