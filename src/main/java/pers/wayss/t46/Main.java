package pers.wayss.t46;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode.cn/problems/permutations/description/
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }
            current.add(num);
            backtrack(nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}