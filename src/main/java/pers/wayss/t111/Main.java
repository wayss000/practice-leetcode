package pers.wayss.t111;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
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
    private int deepLength = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
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
            if (deepLength > currentDeep) {
                deepLength = currentDeep;
            }
        }
    }
}