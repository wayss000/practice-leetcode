package pers.wayss.t77;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode.cn/problems/combinations/description/
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
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        fun(result, new ArrayList<Integer>(), n, k, 1);
        return result;
    }

    public void fun(List<List<Integer>> result, List<Integer> arr, int n, int k, int start) {
        if (arr.size() == k) {
            result.add(new ArrayList<>(arr));
            return;
        }
        if (arr.size() > k) {
            return;
        }
        for (int i = start; i <= n; i++) {
            arr.add(i);
            fun(result, arr, n, k, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}