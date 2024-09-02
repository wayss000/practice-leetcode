package pers.wayss.t283;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/description/
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

    // 循环两次的方法
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0; // 指向下一个非零元素的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 交换
                nums[j++] = nums[i];
            }
        }

        // 将剩余的位置填充为0
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    // 双指针方法
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        // 两个指针i和j
        // j指针表示最左边为0的下标，
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}