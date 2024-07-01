package pers.wayss.t20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 数据结构：数组（字符串转数组）、栈
 * 算法：出栈、入栈操作
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        String s = "()[]{}";
        Solution solution = new Solution();
        System.out.println(solution.isValid2(s));
    }
}

class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Map<Character, Character> keyWords = new HashMap();
        keyWords.put(')', '(');
        keyWords.put(']', '[');
        keyWords.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty()) {
                if (stack.peek() == keyWords.get(c)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.empty();
    }

    public boolean isValid2(String s) {
        if (s == null) {
            return true;
        }
        if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            return isValid2(s.replace("()", "").replace("[]", "").replace("{}", ""));
        } else {
            return s.length() == 0;
        }
    }
}
