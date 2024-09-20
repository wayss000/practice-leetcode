package pers.wayss.t14;

/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix
 * <p>
 * 数据结构：数组、字符串
 * 算法：while循环
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 假设第一个字符串是最长公共前缀
        String prefix = strs[0];

        // 从第二个字符串开始，与前缀进行比较
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // 如果当前字符串不以前缀开头，缩短前缀
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}