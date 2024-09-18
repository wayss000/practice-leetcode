package pers.wayss.t39;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/description/
 * <p>
 * 数据结构：数组
 * 算法：回溯
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        func(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void func(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        int sum = sum(cur);
        if (sum == target) {
            result.add(new ArrayList(cur));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            func(result, cur, candidates, target, i); // 允许重复使用
            cur.remove(cur.size() - 1);
        }
    }

    public int sum(List<Integer> arr) {
        int sum = 0;
        for (int num : arr) {
            sum = sum + num;
        }
        return sum;
    }
}