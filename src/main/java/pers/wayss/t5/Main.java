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
//        String s = "babad";
//        String s = "cbba";
//        String s = "abcda";
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Solution solution = new Solution();
        String result = solution.longestPalindrome(s);
        System.out.println(result);
    }
}

class Solution {
    public String longestPalindrome(String s) {
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
}