package pers.wayss.t94;

import pers.wayss.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }

}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(res, root);
        return res;
    }

    public void inorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(res, root.left);
        res.add(root.val);
        inorderTraversal(res, root.right);
    }

    // 中序遍历的非递归方法
    public void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 遍历到最左节点
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 弹出栈顶节点并访问
            current = stack.pop();
            System.out.print(current.val + " ");

            // 访问右子树
            current = current.right;
        }
    }
}