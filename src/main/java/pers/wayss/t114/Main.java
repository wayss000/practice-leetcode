package pers.wayss.t114;

import pers.wayss.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 *
 * 数据结构：数组、二叉树
 * 算法：树的先序遍历
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        func(queue, root);

        TreeNode cur = root;
        queue.poll();
        while (!queue.isEmpty()) {
            cur.right = queue.poll();
            cur.left = null; // 确保左子树为 null
            cur = cur.right; // 更新 cur 为当前节点的右子树
        }
    }

    public void func(Queue<TreeNode> queue, TreeNode root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        func(queue, root.left);
        func(queue, root.right);
    }
}
