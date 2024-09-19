package pers.wayss.t392;

/**
 * 392. 判断子序列
 * https://leetcode.cn/problems/is-subsequence/description
 * <p>
 * 数据结构：字符串、数组
 * 算法：双指针
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        String s = "bcd";
        String t = "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuubcd";
        Solution solution = new Solution();
        boolean subsequence = solution.isSubsequence(s, t);
        System.out.println(subsequence);
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < sArr.length && tIndex < tArr.length) {
            if (sArr[sIndex] == tArr[tIndex]) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }
        if (sIndex == sArr.length) {
            return true;
        }
        return false;
    }

    // 方法二，思路一样，也是双指针，只是遍历方式不一样
    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) return true;
        for (int i = 0, j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                // 若已经遍历完 s ，则提前返回 true
                if (++i == s.length())
                    return true;
            }
        }
        return false;
    }
}