package pers.wayss.t67;

/**
 * 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 *
 * 数据结构：字符串数组
 * 算法1：二进制相加
 * 算法2：用Long型API
 *
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        Solution solution = new Solution();
        //这俩测试用例会报错
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        solution.addBinary(a,b);
    }
}

class Solution {
    public String addBinary(String a, String b) {
        Long result = Long.parseLong(a, 2) + Long.parseLong(b, 2);
        return Long.toBinaryString(result);
    }
}