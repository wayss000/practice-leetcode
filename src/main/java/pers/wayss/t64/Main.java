package pers.wayss.t64;

/**
 * 64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * 数据结构：数字
 * 算法：递归
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
    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }
}