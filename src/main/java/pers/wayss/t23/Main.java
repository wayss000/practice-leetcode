package pers.wayss.t23;

import pers.wayss.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 23. 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * 数据结构：链表
 * 算法：多个链表复杂操作
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
    }
}

class Solution {
    // 方法一：将K个有序链表，两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwo(result, lists[i]);
        }
        return result;
    }

    // 合并两个有序链表
    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        if (l1 != null) {
            curNode.next = l1;
        }
        if (l2 != null) {
            curNode.next = l2;
        }
        return head.next;
    }

    // 方法二：K个指针合并
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode result = new ListNode(-1);
        ListNode curNode = result;
        List<ListNode> indexs = new ArrayList<>(lists.length);

        // 初始化
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                indexs.add(lists[i]);
            }
        }

        while (!indexs.isEmpty()) {
            // 找到最小的那个节点
            int minVal = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < indexs.size(); i++) {
                if (indexs.get(i) != null && indexs.get(i).val < minVal) {
                    index = i;
                    minVal = indexs.get(i).val;
                }
            }

            if (index == -1) {
                break;
            }

            // 拼接新链表
            curNode.next = indexs.get(index);
            curNode = curNode.next;
            indexs.set(index, indexs.get(index).next);

            if (indexs.get(index) == null) {
                indexs.remove(index);
            }
        }

        return result.next;
    }

}