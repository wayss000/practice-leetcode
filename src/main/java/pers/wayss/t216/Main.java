package pers.wayss.t216;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode.cn/problems/combination-sum-iii/description/
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

        // 回溯
    public void backtrack(int k, int n, int start, List<Integer> current, List<List<Integer>> result) {
        // 步骤1：判断是否符合条件
        if (current.size() == k) {
            if (sum(current) == n) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        // 步骤2：继续下次状态
        for (int i = start; i <= n; i++) {
            // 下一个状态值
            current.add(i);
            backtrack(k, n, i + 1, current, result);
            // 不符合条件，移除上一个状态
            current.remove(current.size() - 1);
        }
    }

    public int sum(List<Integer> list) {
        int total = 0;
        for (Integer i : list) {
            total += i;
        }
        return total;
    }
}