package pers.wayss.t25;

import pers.wayss.common.ListNode;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 *
 * 数据结构：单链表
 * 算法：反转
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode node, int n) {
        if (node == null || n <= 1) return node;

        ListNode dump = new ListNode(0);
        dump.next = node;
        ListNode prevGroupEnd = dump;

        while (true) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = prevGroupEnd;

            // 找到当前组的结束节点
            for (int i = 0; i < n; i++) {
                groupEnd = groupEnd.next;
                if (groupEnd == null) return dump.next; // 不足 n 个节点
            }

            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null; // 断开当前组

            // 反转当前组
            ListNode newGroupStart = reverse(groupStart);
            prevGroupEnd.next = newGroupStart; // 连接前一组
            groupStart.next = nextGroupStart; // 连接下一组

            prevGroupEnd = groupStart; // 更新前一组的结束节点
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev; // 返回新的头节点
    }

}