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
        if (stack1.empty() && stack2.empty()) {
            stack1.add(value);
        } else if (!stack1.isEmpty()) {
            stack1.add(value);
        } else if (!stack2.isEmpty()) {
            stack2.add(value);
        }
    }

    public int deleteHead() {
        if (!stack1.isEmpty()) {
            //栈1不为空，将栈1的元素全部移到栈2
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        } else if (!stack2.isEmpty()) {
            //栈2不为空，将栈2的元素全部移到栈1
            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
            return stack2.pop();
        }
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */