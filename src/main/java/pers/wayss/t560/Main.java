package pers.wayss.t560;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
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
    //双层循环 O(n^2) O(1)
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) {
                    result++;
                }
            }
        }
        return result;
    }

    //用HasMap保存之前的和，时间复杂度O(n) 空间复杂度O(n)
    public int subarraySum1(int[] nums, int k) {
        //currentSum 为遍历到当前元素时，之前的和
        int currentSum = 0;
        int count = 0;
        //map 第一个元素存放 之前的和， 第二个元素存放这个和 已经有多少个次了
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int tempNum : nums){
            currentSum += tempNum;
            if (map.containsKey(currentSum - k)){
                count += map.get(currentSum - k);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}