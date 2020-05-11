package pers.wayss.t50;

/**
 * 50. Pow(x, n)
 * <url>https://leetcode-cn.com/problems/powx-n/</url>
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");

        Solution solution = new Solution();
//        System.out.println(solution.myPow(0, 1));
//        System.out.println(solution.myPow(2.0, 10));
//        System.out.println(solution.myPow(2.1, 3));
//        System.out.println(solution.myPow(2.0, -2));
        System.out.println(solution.myPow(2.0, -2147483648));
    }
}

class Solution {
    /**
     * 时间复杂度O(logN)  空间复杂度O(1)
     */
    public double myPow(double x, int n) {
        double result = 1.0;
        if (n == 0) {
            return result;
        }

        //先转long，防止-Integer.MIN_VALUE越界
        long tempN = n;
        tempN = tempN > 0 ? tempN : -tempN;

        while (tempN > 0) {
            if (tempN % 2 == 1) {
                result *= x;
            }
            x *= x;
            tempN = tempN / 2;
        }

        return n > 0 ? result : 1 / result;
    }


    public double myPow1(double x, int n) {
        long N = n;
        return N > 0 ? func(x, N) : 1.0 / func(x, -N);
    }

    double func(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = func(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}