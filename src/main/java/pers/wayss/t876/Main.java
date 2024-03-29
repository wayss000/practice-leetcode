package pers.wayss.t876;

import pers.wayss.ListNode;

/**
 * 876. 链表的中间结点
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String [] args){
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

