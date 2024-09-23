package pers.wayss.t205;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * https://leetcode.cn/problems/isomorphic-strings/description
 * <p>
 * 数据结构：字符串、哈希表
 * 算法：
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);
            if ((m1.containsKey(c1) && m1.get(c1) != c2) || (m2.containsKey(c2) && m2.get(c2) != c1)) {
                return false;
            }
            m1.put(c1, c2);
            m2.put(c2, c1);
        }
        return true;

    }
}