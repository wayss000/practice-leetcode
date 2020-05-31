package pers.wayss.t120;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
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

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        List<Integer> result = triangle.get(triangle.size() - 1);

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < result.size() && j <= i; j++) {
                result.set(j, triangle.get(i).get(j) + Math.min(result.get(j), result.get(j + 1)));
            }
        }
        return result.get(0);
    }
}