package pers.wayss.t383;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * https://leetcode.cn/problems/ransom-note/description/
 * <p>
 * 数据结构：哈希表、字符串
 * 算法：哈希表
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            Integer count = magazineMap.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            magazineMap.put(c, --count);
        }
        return true;
    }
}