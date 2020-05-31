package pers.wayss.t394;

import java.util.Stack;

/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        Solution solution = new Solution();
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
//        String s = "2[abc]3[cd]ef";
        String s = "3[a]2[b4[F]c]";
        System.out.println(solution.decodeString(s));
    }
}

class Solution {

    //思路，从左向右遍历字符串，同时存入栈中，遇到]出栈，出栈时，遇到[前存入字符串，之后存入数字，再根据这个数字，判断需要循环几次
    public String decodeString(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            //遇到右括号，出栈
            if (ch == ']') {
                Character tempC = stack.pop();
                //出栈时，遇到左括号前，则认为一直是字符
                StringBuilder tempStr = new StringBuilder();
                while (tempC != '[') {
                    tempStr.append(tempC);
                    tempC = stack.pop();
                }
                //出了循环，则应该就是数字了
                StringBuilder tempDigitStr = new StringBuilder();
                tempC = stack.pop();
                while (Character.isDigit(tempC)) {
                    tempDigitStr.append(tempC);
                    //数字时，有可能是最前的数字，会是空栈
                    if (stack.isEmpty()) {
                        break;
                    }
                    tempC = stack.pop();
                }

                StringBuilder str = tempStr.reverse();
                StringBuilder digitStr = tempDigitStr.reverse();
                int digit = Integer.parseInt(digitStr.toString());
                StringBuilder tempResult = new StringBuilder();
                for (int j = 0; j < digit; j++) {
                    tempResult.append(str);
                }

                //栈不为空，说明当前子串和前面串要做计算，把子串再塞进栈里去
                if (!stack.isEmpty()) {
                    stack.push(tempC);
                    for (Character character : tempResult.toString().toCharArray()) {
                        stack.push(character);
                    }
                }else {
                    result.append(tempResult);
                }
            } else {
                stack.push(ch);
            }
        }
        //返回之前，看看栈中还有没有剩余字符串
        StringBuilder last = new StringBuilder();
        while (!stack.isEmpty()) {
            last.append(stack.pop());
        }
        result.append(last.reverse());

        return result.toString();
    }
}