package pers.wayss.t232;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
    }

    /**
     * 相比下面的pop1()方法：
     * 时间复杂度在最坏情况下为 (O(n))，但在大多数情况下为 (O(1))
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }

    /**
     * 相比上面的pop方法，每次都要移动，性能差
     */
    public int pop1() {
        if (!stack1.isEmpty()) {
            //栈1不为空，将栈1的元素全部移到栈2
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            int temp = stack2.pop();
            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
            return temp;
        } else {
            return -1;
        }
    }


    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.peek();
        }
    }


    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
