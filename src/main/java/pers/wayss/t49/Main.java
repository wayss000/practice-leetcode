package pers.wayss.t49;

import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/description
 * <p>
 * 数据结构：字符串、哈希表
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
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            // 异位词排序后的字符均相等，因此做hash表的key
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}