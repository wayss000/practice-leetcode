package pers.wayss.t1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 *
 * 数据结构：数组
 * 算法：无（数据基本操作）
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
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int val : candies) {
            if (val > maxCandy) {
                maxCandy = val;
            }
        }
        Boolean[] result = new Boolean[candies.length];
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies < maxCandy) {
                result[i] = false;
            } else {
                result[i] = true;
            }
        }
        return Arrays.asList(result);
    }
}