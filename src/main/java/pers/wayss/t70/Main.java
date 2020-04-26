package pers.wayss.t70;

/**
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    //递归解法，不能满足时间复杂度O(n)
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        if (n <= 2){
            return n;
        }
        int tempOne = 1;
        int tempTwo = 2;
        int result = 0;
        for (int i = 3; i <= n; i++){
            result = tempOne + tempTwo;
            tempOne = tempTwo;
            tempTwo = result;
        }

        return result;
    }
}