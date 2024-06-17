package pers.wayss.t125;

/**
 * 125. 验证回文串
 * https://leetcode.cn/problems/valid-palindrome/description/
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(charArray[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(charArray[right])) {
                right--;
            }
            if (Character.toLowerCase(charArray[left]) != Character.toLowerCase(charArray[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}