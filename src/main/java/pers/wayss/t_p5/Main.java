package pers.wayss.t_p5;

import java.util.ArrayList;
import java.util.List;

/**
 * 高德笔试题目
 * 输入：int[] 数组
 * 若：相邻的3个sum > 100,且 连续的4组或4组以上sum>100（3个相邻数之和为一组），那么输出当前的全部
 * 输入
 * 10,50,60,40,3,80,18,1,10,90,30,40,40,10,10,10,90
 * 输出
 * 10,50,60,40,3,80,18
 * 1,10,90,30,40,40
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        int[] nums = {10, 50, 60, 40, 3, 80, 18, 1, 10, 90, 30, 40, 40, 10, 10, 10, 90};
        func(nums);
    }

    public static List<List<Integer>> func(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2;) {
            int count = 0;
            int start = i;
            for (int j = i + 2; j < nums.length; j++) {
                int end = j;
                List<Integer> tempList = new ArrayList<>();
                tempList.add(nums[j]);
                tempList.add(nums[j - 1]);
                tempList.add(nums[j - 2]);
                if (isMoreThan100(tempList)) {
                    count++;
                } else {
                    if (count >= 4) {
                        List<Integer> temp2 = new ArrayList<>();
                        for (int k = start; k < end; k++) {
                            temp2.add(nums[k]);
                        }
                        result.add(temp2);
                        i = j;
                        break;
                    }
                }
                i = j;
            }
        }
        System.out.println(result);
        return result;
    }

    public static boolean isMoreThan100(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum > 100;
    }
}
