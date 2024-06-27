package pers.wayss.t2;

import java.math.BigInteger;

import pers.wayss.common.ListNode;

/**
 * 2. 两数相加
 * <url>https://leetcode-cn.com/problems/add-two-numbers/</url>
 *
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 链表遍历相加
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dump = new ListNode();
        ListNode cur = dump;
        int lastNum = 0;
        while (l1 != null && l2 != null) {
            // 取链表第一个数，相加
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1 + val2 + lastNum;
            // 大于10需要进位，特殊处理
            ListNode temp = new ListNode();
            if (sum >= 10) {
                temp.val = sum % 10;
                lastNum = sum / 10;
            } else {
                temp.val = sum;
                lastNum = 0;
            }
            cur.next = temp;
            cur = temp;
            // 指针后移
            l1 = l1.next;
            l2 = l2.next;
        }
        // l1 或 l2 哪个链表更长
        while (l1 != null) {
            int val = l1.val;
            // 大于10需要进位，特殊处理
            ListNode temp = new ListNode();
            int sum = lastNum + val;
            if (sum >= 10) {
                temp.val = sum % 10;
                lastNum = sum / 10;
            } else {
                temp.val = sum;
                lastNum = 0;
            }
            cur.next = temp;
            cur = temp;
            // 指针后移
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val;
            // 大于10需要进位，特殊处理
            ListNode temp = new ListNode();
            int sum = lastNum + val;
            if (sum >= 10) {
                temp.val = sum % 10;
                lastNum = sum / 10;
            } else {
                temp.val = sum;
                lastNum = 0;
            }
            cur.next = temp;
            cur = temp;
            // 指针后移
            l2 = l2.next;
        }
        if (lastNum > 0) {
            ListNode temp = new ListNode();
            temp.val = lastNum;
            cur.next = temp;
        }
        return dump.next;
    }

    // 偷懒实现，两个链表遍历，后的数再反转，再调用大数相加api实现后，再生成新的链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        //遍历获取第一个数，并反转得其实际值
        StringBuilder num1Str = new StringBuilder();
        ListNode p1 = l1;
        while (p1 != null) {
            num1Str.append(p1.val);
            p1 = p1.next;
        }
        num1Str.reverse();
        BigInteger num1 = new BigInteger(num1Str.toString());

        //遍历获取第二个数，并反转得其实际值
        StringBuilder num2Str = new StringBuilder();
        ListNode p2 = l2;
        while (p2 != null) {
            num2Str.append(p2.val);
            p2 = p2.next;
        }
        num2Str.reverse();
        BigInteger num2 = new BigInteger(num2Str.toString());

        //两个大数相加，得结果数
        BigInteger num3 = num1.add(num2);

        //取最后一位数字，存入链表
        //这里用了BigInteger取余取整的API，divideAndRemainder函数
        BigInteger divideBy10 = new BigInteger("10");

        BigInteger[] divedeArr = num3.divideAndRemainder(divideBy10);
        ListNode head = new ListNode(divedeArr[1].intValue());
        BigInteger tempNum = divedeArr[0];

        ListNode temp = head;
        BigInteger zeroValue = new BigInteger("0");
        while (tempNum.compareTo(zeroValue) > 0) {
            divedeArr = tempNum.divideAndRemainder(divideBy10);
            tempNum = divedeArr[0];
            temp.next = new ListNode(divedeArr[1].intValue());
            temp = temp.next;
        }

        return head;
    }
}