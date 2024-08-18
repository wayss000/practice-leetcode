package pers.wayss.t242;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * 数据结构：字符串、字符数组
 * 算法：哈希表
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
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (t == null) {
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (countMap.get(ch) != null) {
                int tempCount = countMap.get(ch);
                tempCount++;
                countMap.put(ch, tempCount);
            } else {
                countMap.put(ch, 1);
            }
        }
        for (Character ch : t.toCharArray()){
            if (countMap.get(ch) == null){
                return false;
            }else {
                int tempCount = countMap.get(ch);
                tempCount--;
                if (tempCount == 0){
                    countMap.remove(ch);
                }else{
                    countMap.put(ch, tempCount);
                }
            }
        }
        if (countMap.size() == 0){
            return true;
        }
        return false;
    }
}