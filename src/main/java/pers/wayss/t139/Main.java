package pers.wayss.t139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * https://leetcode.cn/problems/word-break/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String [] args){
        System.out.println("practice leetcode.");

        Solution solution = new Solution();
        String[] wordDicts = {"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict = Arrays.asList(wordDicts);
        String s = "catsand";
        System.out.println(solution.wordBreak(s,wordDict));
    }
}

class Solution {
    //TODO wayss 下面这是官方答案，暂时还没看懂
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}