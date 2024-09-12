package pers.wayss.t144;

import pers.wayss.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144.二叉树的前序遍历、先序遍历
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

    // 递归实现
    public void preorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preorderTraversal(res, root.left);
        preorderTraversal(res, root.right);
    }

    // 非递归前序遍历方法
    public void preOrderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            // 先压右子节点，后压左子节点
            // 这样在下次循环中会先处理左子节点
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
