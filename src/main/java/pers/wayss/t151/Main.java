package pers.wayss.t151;

/**
 * 151. 反转字符串中的单词
 * https://leetcode.cn/problems/reverse-words-in-a-string/description
 * <p>
 * 数据结构：字符串
 * 算法：双指针、字符串分割
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    // 方法一：按照空格分割为字符串数组，并倒序将字符数组拼接
    public String reverseWords(String s) {
        // 去除首尾空格，并按空格分割字符串
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        // 反向遍历单词数组
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" "); // 添加空格
            }
        }
        return reversed.toString();
    }

    // 方法二：双指针，遇到空格就暂停，并用substring截取单词
    public String reverseWords1(String s) {
        s = s.trim();                                    // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            // 搜索首个空格，循环条件：不为空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            res.append(s.substring(i + 1, j + 1) + " ");
            // 跳过单词间空格，循环条件：为空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }
}