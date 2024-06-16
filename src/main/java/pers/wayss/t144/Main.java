package pers.wayss.t144;

import pers.wayss.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }

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

