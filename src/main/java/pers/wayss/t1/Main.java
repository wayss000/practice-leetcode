package pers.wayss.t1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <url>https://leetcode-cn.com/problems/two-sum/</url>
 *
 * 数据结构：数组、哈希表
 * 算法：for循环（用哈希表空间复杂度解决2层for循环的时间复杂度）
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
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                result[1] = j;
                if (nums[result[0]] + nums[result[1]] == target) {
                    return result;
                }
            }
        }
        return result;
    }


    public int[] twoSum1(int[] nums, int target) {
        // hashtable的key位数组的值，value为数组的下标
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}