package pers.wayss.t415;

/**
 * 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "111";
        String num2 = "111";
        String result = solution.addStrings(num1, num2);
        System.out.println(result);
    }
}

/**
 * 这道题的难点之一是：char和int的互相转换
 * char to int : 减 char类型 '0'
 * int to char : 加 char类型 '0'
 * <p>
 * 另外，大于等于0之类的边界条件，需要想清楚
 */
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }

        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();

        int length = Math.max(num1Arr.length, num2Arr.length);
        char[] num3_R = new char[length + 1];

        for (int i = 0; i < length; i++) {
            int n1 = 0;
            int n2 = 0;
            if (num1Arr.length - 1 - i >= 0) {
                n1 = num1Arr[num1Arr.length - 1 - i] - '0';
            }
            if (num2Arr.length - 1 - i >= 0) {
                n2 = num2Arr[num2Arr.length - 1 - i] - '0';
            }
            int n3 = 0;
            char c = num3_R[i];
            if (c == 0) {
                //not to do
            } else {
                n3 = c - '0';
            }
            int tempSum = n1 + n2 + n3;
            int temp1 = tempSum % 10;
            int temp2 = tempSum / 10;
            num3_R[i] = (char) (temp1 + '0');
            num3_R[i + 1] = (char) (temp2 + '0');
            System.out.println(num3_R);
        }

        String num3Str = String.valueOf(num3_R);

        StringBuilder stringBuilder = new StringBuilder(num3Str);
        String result = stringBuilder.reverse().toString();
        if (result.startsWith("0")) {
            return result.substring(1);
        }
        return result;
    }
}