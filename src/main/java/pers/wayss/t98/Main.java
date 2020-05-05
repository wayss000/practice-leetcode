package pers.wayss.t98;

/**
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root, null, null);
    }

    /**
     * @param root 子树的根
     * @param min  子树的下界，即，子树的所有元素值均应该大于min
     * @param max  子树的上届，即，子树的所有元素值均应该小于max
     * @return
     */
    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        // 左子树设置上界
        // 右子树设置下界
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    /**
     * 方法二：利用中序遍历，保存上一个元素，对比上一个元素和当前元素的大小。
     * 原理：二叉搜索树的中序遍历是一个递增的数组。
     *
     * @param root
     * @return
     */
    Integer prevVal = null;

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        //先左子树，左子树返回false时，表示左子树 不是有效的二叉搜索树，直接返回
        if (!isValidBST1(root.left)) {
            return false;
        }

        //比较大小
        if (prevVal > root.val) {
            return false;
        } else {
            //中序遍历保存当前元素
            prevVal = root.val;
        }

        //最后右子树
        return isValidBST1(root.right);
    }
}