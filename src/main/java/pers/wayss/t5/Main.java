package pers.wayss.t5;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. 最长回文子串
 * <url>https://leetcode-cn.com/problems/longest-palindromic-substring/</url>
 *
 * 数据结构：数组（需要将字符串转数组处理）
 * 算法1：双指针，while循环，2个指针往两边扩大，记录符合最长的子串
 * 算法2：动态规划，在子串长度大于3时，dp[i][j] = dp[i + 1][j - 1];
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
//        String s = "babad";
        String s = "abcdeef";
//        String s = "abcda";
//        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Solution solution = new Solution();
        String result = solution.longestPalindrome(s);
        System.out.println(result);
    }
}

class Solution {

    //方法一：动态规划
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        char[] charArray = s.toCharArray();
        int length = charArray.length;

        if (length < 2) {
            return s;
        }

        int maxLength = 1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    //方法二：穷举法
    public String longestPalindrome1(String s) {
        return test1(s);
    }

    /**
     * 算法是正确的，但是性能不满足：超出内存限制
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
        //遍历母字符串的所有字符，获取所有子串
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i]);
            sbList.add(sb);
            if (i == arr.length - 1) {
                break;
            }
            for (int j = i + 1; j < arr.length; j++) {
                StringBuilder tempSB = new StringBuilder(sbList.get(sbList.size() - 1));
                tempSB.append(arr[j]);
                sbList.add(tempSB);
            }
        }

        sbList = checkPalindromicSubstring(sbList);

        //找出最长的回文串
        StringBuilder result = null;
        int maxLength = 0;
        for (StringBuilder sb : sbList) {
            if (sb.toString().length() > maxLength) {
                maxLength = sb.toString().length();
                result = sb;
            }
        }

        return result == null ? "" : result.toString();
    }

    /**
     * 找出入参字符串数组中所有回文串，将非回文串移除<br>
     * 算法：对比子串第一个字符和最后一个字符是否相同，第二个和倒数第二个是否相等，依次类推
     *
     * @param sbList
     */
    List<StringBuilder> checkPalindromicSubstring(List<StringBuilder> sbList) {
        List<StringBuilder> palindromicList = new ArrayList<>();
        for (StringBuilder sb : sbList) {
            char[] strArr = sb.toString().toCharArray();
            //times表示循环的次数
            int times = strArr.length / 2;
            //isPalinadromic表示回文数的标志
            boolean isPalinadromic = true;
            for (int i = 0; i < times; i++) {
                if (strArr[i] != strArr[strArr.length - 1 - i]) {
                    isPalinadromic = false;
                    break;
                }
            }
            if (isPalinadromic) {
                palindromicList.add(sb);
            }
        }
        return palindromicList;
    }

    // 2024-03-27 双指针法解决
    public String doublePoint(String s) {
        String result = "";
        if (s == null) {
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            String s1 = resultPalindromic(s, i, i);
            String s2 = resultPalindromic(s, i, i+1);
            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }
        return result;
    }

    public String resultPalindromic(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}