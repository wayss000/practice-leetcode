package pers.wayss.t55;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 *
 * 数据结构：数组
 * 算法：贪心算法（贪心算法的核心思想是每一步都选择当前能做的最优选择，以期望通过局部最优解达到全局最优解）
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