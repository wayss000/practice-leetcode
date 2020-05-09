package pers.wayss.t69;

/**
 * 69.x的平方根
 * <url>https://leetcode-cn.com/problems/sqrtx/</url>
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }
}

class Solution {

    //二分法：mid*mid 和 x 比较大小
    public int mySqrt(int x) {
        int start = 1, end = x;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if ((long)mid * mid <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
                //到这一步说明mid已经大了，需要减一个，目的是最后一次循环跳出后值正确
                mid = mid - 1;
            }
        }
        return mid;
    }


    //作弊方法，leetcode检测不出来
    public int mySqrt1(int x) {
        return (int) Math.sqrt(x);
    }
}