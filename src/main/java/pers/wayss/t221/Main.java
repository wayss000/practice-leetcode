package pers.wayss.t221;

/**
 * 221. 最大正方形
 * <url>https://leetcode-cn.com/problems/maximal-square/</url>
 *
 * 数据结构：数据
 * 算法：动态规划
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
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int[][] dp = new int[row][column];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    //第一行或第一列，最大只能为1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        return maxSide * maxSide;
    }
}