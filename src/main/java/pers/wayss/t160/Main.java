package pers.wayss.t160;

import pers.wayss.ListNode;

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 双指针思路 题解：https://labuladong.online/algo/essential-technique/linked-list-skills-summary-2/#%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E6%98%AF%E5%90%A6%E7%9B%B8%E4%BA%A4
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            if (h1 != null) {
                h1 = h1.next;
            } else {
                h1 = headB;
            }

            if (h2 != null) {
                h2 = h2.next;
            } else {
                h2 = headA;
            }
        }
        return h1;
    }
}