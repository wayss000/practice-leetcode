package pers.wayss.t_p4;

public class TestTreeNode<T> {
    private TestTreeNode<T> parent;
    private TestTreeNode<T> left;
    private TestTreeNode<T> right;
    private T val;

    public TestTreeNode() {}

    public TestTreeNode(T value) {
        this.val = value;
    }

    public TestTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TestTreeNode<T> parent) {
        this.parent = parent;
    }

    public TestTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TestTreeNode<T> left) {
        this.left = left;
    }

    public TestTreeNode<T> getRight() {
        return right;
    }

    public void setRight(TestTreeNode<T> right) {
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}
