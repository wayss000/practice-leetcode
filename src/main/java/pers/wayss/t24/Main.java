package pers.wayss.t24;

/**
 * @author Wayss.
 * @date 2019/10/17.
 */
public class Main {
    public static void main(String [] args){
        System.out.println("practice leetcode.");
    }
}

//1 2 3 4 null
//2 1 4 3 null
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode prev = temp;

        while (head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            head = first.next;
        }
        return temp.next;
    }
}