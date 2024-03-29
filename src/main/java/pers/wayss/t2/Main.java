package pers.wayss.t2;

import java.math.BigInteger;

import pers.wayss.ListNode;

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