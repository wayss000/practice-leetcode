package pers.wayss.t9;

/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(0));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        //前三个判断减少循环次数
        if (x < 0) {
            return false;
        }
        if( x == 0){
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int another = 0;
        int tempB = x;
        //思路：声明一个another数，把入参数，从个位起依次翻转，赋值给another数，最后作比较
        do {
            int tempA = tempB % 10;
            another = another * 10 + tempA;
            tempB = tempB / 10;
        } while (tempB > 0);
        if (another == x) {
            return true;
        }
        return false;
    }
}