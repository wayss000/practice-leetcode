package pers.wayss.t86;

import pers.wayss.ListNode;

/**
 * 86. 分隔链表
 * https://leetcode.cn/problems/partition-list/
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String [] args){
        System.out.println("practice leetcode.");
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode p1 = less;

        ListNode big = new ListNode(-1);
        ListNode p2 = big;

        ListNode p = head;

        while (p != null) {
            if (p.val >= x){
                p2.next = p;
                p2 = p2.next;
            }else {
                p1.next = p;
                p1 = p1.next;
            }

            ListNode temp = p.next;
            p.next = null;
            p = temp;

        }
        p1.next = big.next;
        return less.next;
    }
}

