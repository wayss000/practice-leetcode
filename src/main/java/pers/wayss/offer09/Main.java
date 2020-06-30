package pers.wayss.offer09;

import java.util.Stack;

/**
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack1.isEmpty()) {
            //栈1不为空，将栈1的元素全部移到栈2
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            int temp = stack2.pop();
            while (!stack2.isEmpty()){
                stack1.add(stack2.pop());
            }
            return temp;
        }else {
            return -1;
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */