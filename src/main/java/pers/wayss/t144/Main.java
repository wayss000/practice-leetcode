package pers.wayss.t144;

import pers.wayss.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144.二叉树的前序遍历
 * <url>https://leetcode.cn/problems/binary-tree-preorder-traversal/</url>
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(res, root);
        return res;
    }

    public void preorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preorderTraversal(res, root.left);
        preorderTraversal(res, root.right);
    }
}
