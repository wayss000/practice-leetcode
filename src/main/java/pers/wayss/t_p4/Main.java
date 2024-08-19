package pers.wayss.t_p4;

/**
 * 面试题：写一个数据结构：二叉树的节点
 * 算法：初始化满二叉树，输入层数n，返回root节点
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");

        int n = 3;
        Solution solution = new Solution();
        TestTreeNode<Integer> root = solution.generateTree(n);
        System.out.println(root);
        System.out.println("end");
    }
}

class Solution {
    /**
     * @param n 入参n，表示满二叉树的层数：n层
     * @return 返回二叉树的根节点
     */
    public TestTreeNode<Integer> generateTree(int n) {
        TestTreeNode<Integer> root = new TestTreeNode<Integer>(1);
        return addLevel(root, 0, n);
    }

    public TestTreeNode<Integer> addLevel(TestTreeNode<Integer> node, int level, int n) {
        TestTreeNode<Integer> left = null;
        TestTreeNode<Integer> right = null;
        if (level < n - 1) {
            level = level + 1;

            left = new TestTreeNode<Integer>(node.getVal() * 2);
            left.setParent(node);

            right = new TestTreeNode<Integer>(node.getVal() * 2 + 1);
            right.setParent(node);

            node.setLeft(left);
            node.setRight(right);

            addLevel(node.getLeft(), level, n);
            addLevel(node.getRight(), level, n);
            // set root val
        }
        return node;
    }
}



