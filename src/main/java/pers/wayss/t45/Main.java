package pers.wayss.t45;

/**
 * 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/description
 * <p>
 * 数据结构：数组
 * 算法：贪心算法
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    // 方法一：贪心算法，正向查找可到达的最大位置，时间复杂度 O(n)
    public int jump(int[] nums) {
        int step = 0;
        int maxIndex = 0;
        int canEnd = 0;
        // nums.length - 2 到倒数第二个元素，是因为我们不需要在最后一个位置进行跳跃
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            // i == canEnd 表示我们已经用完了当前的跳跃范围
            if (i == canEnd) {
                // 更新 end 为 maxPosition，表示我们要跳到的新的边界
                canEnd = maxIndex;
                step++;
            }
        }
        return step;
    }

    // 方法二：反向查找出发位置，时间复杂度 O(n^2)
    public int jump2(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}