package pers.wayss.t145;

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

