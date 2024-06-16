package pers.wayss.t102;

import pers.wayss.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * <url>https://leetcode-cn.com/problems/binary-tree-level-order-traversal/</url>
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                //左子树不为空，队列中添加左
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                //右子树不为空，队列中添加右
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}