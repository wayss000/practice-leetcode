package pers.wayss.t3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Wayss.
 * @date 2019/10/13.
 */
public class Main {
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        return test2(s);
    }

    /**
     * 双指针解法
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @return
     */
    private int test(String s){
        int maxLength = 0;
        if(s == null){
            return maxLength;
        }
        Map<Character,Integer> mapIndex = new HashMap<>();
        char[] array = s.toCharArray();
        for(int start = 0,end = 0;end < array.length;end++){
            //判断当前end所在元素是否在map中出现
            //是：将start移到 end所在元素上一次出现之后，但要小心避免往回移（即，取较大的下标）
            Integer temp = mapIndex.get(array[end]);
            if(temp != null){
                start = Math.max(start,temp+1);
            }
            maxLength = Math.max(maxLength, end-start+1);
            mapIndex.put(array[end],end);
        }
        return maxLength;
    }

    /**
     * 正确
     * 执行用时 :159 ms, 在所有 java 提交中击败了12.60%的用户
     * 内存消耗 :50.8 MB, 在所有 java 提交中击败了23.79%的用户
     */
    private int test2(String s) {
        /*
        思路：穷举法
        1.以每个字符开始，将大串分成若干小串，子串的结尾标志是遇到该串中已经出现的字符
        2.比较每个子串，取长度最长子串的长度为结果
        缺点：这种算法当字符串s中的所有字符不重复时性能最差，时间复杂度n*n!，空间复杂度n!
         */

        //存储子串的List
        List<StringBuilder> subString = new ArrayList<>();
        char[] arr = s.toCharArray();
        //tag表示不包含重复字符的子串，在subString的第一个位置
        int tag = 0;
        for (int i = 0; i < arr.length; i++) {
            //判断当前字符是否在子串中
            for (int j = tag; j < subString.size(); j++) {
                StringBuilder tmpS = subString.get(j);
                int index = tmpS.indexOf(arr[i] + "");
                //index > -1时为在子串中
                if (index > -1) {
                    tag = j + 1;
                } else {
                    tmpS.append(arr[i]);
                }
            }

            //新的子串对象
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i]);
            subString.add(sb);
        }

        int maxValue = 0;
        for (StringBuilder tempSb : subString) {
            if (maxValue < tempSb.length()) {
                maxValue = tempSb.length();
            }
        }
        return maxValue;
    }


    /**
     * 错误的方法，不支持"dvdf"
     */
    private int test1(String s) {
        /*思路:
        1.遍历入参字符串，分割成无重复的若干子串；
            1.0每当有重复过的字符出现时，则可以产生一个新子串了；
            1.1用HashMap在遍历时判断当前字符是否在当前；
            1.2用ArrayList存储无重复的子串；
        2.比较所有子串，找出最长的那一个。
         */

        //判断当前字符是否出现过的Map
        Map repeatMap = new HashMap<>();
        //存储子串的List
        List<StringBuilder> subString = new ArrayList<>();
        //标志位，判断当前字符是否是子串的第一个
        boolean isFirstChar = true;
        //子串对象
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            //判断当前字符是否出现过
            if (repeatMap.get(arr[i]) == null) {
                /*repeatMap.get(arr[i]) == null(未出现过的两种情况)：
                1.当前字符是新子串的第一个字符
                2.当前字符在当前子串中没有出现过
                 */
                if (isFirstChar) {
                    sb.append(arr[i]);
                    subString.add(sb);
                    repeatMap.put(arr[i], true);
                    isFirstChar = false;
                } else {
                    sb = subString.get(subString.size() - 1);
                    sb.append(arr[i]);
                    repeatMap.put(arr[i], true);
                }
            } else {
                /*repeatMap.get(arr[i]) != null 时，
                表示 当前字符在当前子串中已经有重复了，
                此时 重置repeatMap
                new新的子串，并重置isFirstChar
                 */
                repeatMap.clear();
                sb = new StringBuilder();
                sb.append(arr[i]);
                repeatMap.put(arr[i], true);
                isFirstChar = true;
            }
        }

        int maxValue = 0;
        for (StringBuilder tempSb : subString) {
            if (maxValue < tempSb.length()) {
                maxValue = tempSb.length();
            }
        }
        return maxValue;
    }
}