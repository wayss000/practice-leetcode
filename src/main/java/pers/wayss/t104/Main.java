package pers.wayss.t104;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String [] args){
        System.out.println("practice leetcode.");
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int deepLength = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        deep(root, 0);
        return deepLength;
    }
    public void deep(TreeNode root, int parentDeep) {

        //树的深度+1
        int currentDeep = ++parentDeep;
        //有子节点则继续递归
        if (root.left != null) {
            deep(root.left, currentDeep);
        }
        if (root.right != null) {
            deep(root.right, currentDeep);
        }
        //当为叶子节点时，修改deepLength值
        if (root.left == null && root.right == null) {
            if (deepLength < currentDeep) {
                deepLength = currentDeep;
            }
        }
    }

    // 递归的另一种写法
    public int maxDepth_1(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        return maxDepth_1(root, maxDepth);
    }

    public int maxDepth_1(TreeNode root, int maxDepth) {
        if (root == null) {
            return maxDepth;
        }
        maxDepth++;
        return Math.max(maxDepth_1(root.left, maxDepth), maxDepth_1(root.right, maxDepth));
    }
}
