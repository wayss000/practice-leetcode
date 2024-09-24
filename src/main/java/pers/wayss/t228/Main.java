package pers.wayss.t228;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * https://leetcode.cn/problems/summary-ranges/description/
 * <p>
 * 数据结构：数组
 * 算法：双指针
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            // 记录起始指针
            int low = i;
            // 寻找下一个
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            // 因为循环结束的条件是 nums[i] == nums[i - 1] + 1，因此，high指针需要回退一位
            int high = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}