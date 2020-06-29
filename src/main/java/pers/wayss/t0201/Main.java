package pers.wayss.t0201;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 02.01. 移除重复节点
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
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
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head.next;
        ListNode pre = head;

        Map<Integer, Boolean> map = new HashMap<>();
        map.put(pre.val, true);

        while (current != null) {
            if (map.get(current.val) != null) {
                pre.next = current.next;
            }else{
                pre = pre.next;
            }
            current = pre.next;
            map.put(pre.val, true);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}