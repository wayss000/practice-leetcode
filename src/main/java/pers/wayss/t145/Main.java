package pers.wayss.t145;

import pers.wayss.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * <url>https://leetcode.cn/problems/binary-tree-postorder-traversal/description/</url>
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }

}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(res, root);
        return res;
    }

    public void postorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) return;
        postorderTraversal(res, root.left);
        postorderTraversal(res, root.right);
        res.add(root.val);
    }
}
