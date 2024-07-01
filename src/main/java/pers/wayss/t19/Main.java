package pers.wayss.t19;

import pers.wayss.common.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * 数据结构：单链表
 * 算法：双指针（fast指针先走N步）
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }

}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode node = theNode(dump, n + 1);
        node.next = node.next.next;
        return dump.next;
    }

    public ListNode theNode(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

