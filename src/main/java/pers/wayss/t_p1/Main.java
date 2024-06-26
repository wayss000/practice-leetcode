package pers.wayss.t_p1;

import java.util.ArrayList;
import java.util.List;

/**
 * xx二面算法题：寻找指定k个数的和为m的所有组合
 * (暂未在leetcode找到原题)
 * <p>
 * 给定随机数组 data[]，寻找指定k个数的和为m的所有组合，例如
 * 输入：int data[] = {1,2,3,4,5,6,8,10};
 * int k = 2;
 * int m = 7;
 * 返回： {{1, 6}, {2, 5}, {3, 4}}
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
//        int[] data = {1, 2, 3, 4, 5, 6, 8, 10};
//        int k = 2;
//        int m = 7;
        int[] data = {1, 2, 3, 4, 5};
        int k = 3;
        int m = 8;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.findData(data, k, m);
        System.out.println(result);
    }
}

class Solution {
    public List<List<Integer>> findData(int[] data, int k, int m) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(data, k, m, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] data, int k, int m, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            if (sum(current) == m) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i < data.length; i++) {
            current.add(data[i]);
            backtrack(data, k, m, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    private int sum(List<Integer> list) {
        int total = 0;
        for (int num : list) {
            total += num;
        }
        return total;
    }
}
