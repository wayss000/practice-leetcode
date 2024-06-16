package pers.wayss.t94;

import pers.wayss.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }

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
}

