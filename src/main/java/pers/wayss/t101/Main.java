package pers.wayss.t101;

import pers.wayss.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return recurSive(root, root);
    }
    //递归实现
    boolean recurSive(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        return left.val == right.val && recurSive(left.left, right.right) &&  recurSive(left.right, right.left);
    }
    //循环（迭代）实现，利用队列
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> one = new LinkedList<>();
        Queue<TreeNode> two = new LinkedList<>();
        one.add(root);
        two.add(root);
        while (!one.isEmpty()){
            TreeNode left = one.poll();
            TreeNode right = two.poll();
            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            one.add(left.left);
            two.add(right.right);
            one.add(left.right);
            two.add(right.left);
        }
        return true;
    }
}
