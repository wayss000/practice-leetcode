package pers.wayss.t5;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. 最长回文子串
 * <url>https://leetcode-cn.com/problems/longest-palindromic-substring/</url>
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
    public String longestPalindrome(String s) {
        return test1(s);
    }

    /**
     */
    String test1(String s) {

        /*
        思路：
        1.计算出所有的子串；
        2.找出所有的回文串；
        3.找出长度最长的回文串；
         */
        List<StringBuilder> sbList = new ArrayList<>();

        char[] arr = s.toCharArray();
        //遍历母字符串的所有字符
        for (int i = 0; i < arr.length; i++) {
            //将当前遍历的字符添加到之前的子字符串中
            for (StringBuilder sb : sbList) {
                sb.append(arr[i]);
            }
            //以当前字符串为第一个字符串，生成一个新的字符串
            StringBuilder tempSB = new StringBuilder();
            tempSB.append(arr[i]);
            sbList.add(tempSB);
        }

        checkPalindromicSubstring(sbList);

        return null;
    }

    /**
     * 找出所有回文串
     * @param sbList
     */
    void checkPalindromicSubstring(List<StringBuilder> sbList){
        for (StringBuilder sb : sbList){

        }
    }
}