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

    /**
     * 下面是ChatGPT给的.
     * <p>
     * 解释：
     * 循环条件：while (i >= 0 || j >= 0 || carry != 0)，确保所有位都处理完并且最后的进位也处理完。
     * 当前位处理：
     * x 和 y 分别是 num1 和 num2 当前位的数字，如果当前位不存在则视为 0。
     * sum 是当前位的和加上进位。
     * sum % 10 得到当前位的结果，将其添加到 StringBuilder 中。
     * sum / 10 计算新的进位。
     * 指针移动：i-- 和 j-- 分别向前移动指针。
     * 反转结果：由于 StringBuilder 中的结果是从低位到高位的，因此需要反转。
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings2(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        return result.reverse().toString();
    }
}