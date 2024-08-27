package pers.wayss.t572;

import pers.wayss.common.TreeNode;

import java.util.Stack;

/**
 * 572. 另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
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
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 方法一：递归实现
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null){
            return false;
        }
        return check(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean check(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val == b.val) {
            return check(a.left, b.left) && check(a.right, b.right);
        }
        return false;
    }

    // 方法二：非递归实现，用了栈数据结构
    public boolean isSubtree2(TreeNode subRoot, TreeNode root) {
        if (root == null) {
            return true; // 空树是任何树的子树
        }
        if (subRoot == null) {
            return false; // 非空树不能包含空树
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(subRoot);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // 如果当前节点的值与子树的根节点值相同，进行比较
            if (node.val == root.val) {
                if (isSameTree(node, root)) {
                    return true;
                }
            }

            // 继续遍历主树的左右子树
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return false;
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{s, t});

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];

            if (node1 == null && node2 == null) {
                continue; // 两个节点都为空，继续
            }
            if (node1 == null || node2 == null) {
                return false; // 其中一个为空，返回 false
            }
            if (node1.val != node2.val) {
                return false; // 值不相等，返回 false
            }

            // 压入左右子节点进行比较
            stack.push(new TreeNode[]{node1.left, node2.left});
            stack.push(new TreeNode[]{node1.right, node2.right});
        }

        return true;
    }
}

