package pers.wayss.t141;

import pers.wayss.common.ListNode;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/description/
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 哈希表方式
    public boolean hasCycle1(ListNode head) {
        return false;
    }
}