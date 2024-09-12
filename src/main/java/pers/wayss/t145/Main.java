package pers.wayss.t145;

import pers.wayss.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    // 递归实现
    public void postorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) return;
        postorderTraversal(res, root.left);
        postorderTraversal(res, root.right);
        res.add(root.val);
    }

    // 非递归方法，用栈
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> output = new Stack<>();  // 用于存储后序遍历的结果

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node.val);  // 先将根节点压入输出栈

            // 先压左子节点，再压右子节点
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        // 输出后序遍历结果
        while (!output.isEmpty()) {
            System.out.print(output.pop() + " ");
        }
    }
}
