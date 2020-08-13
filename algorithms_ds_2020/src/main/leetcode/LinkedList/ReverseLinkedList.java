package main.leetcode.LinkedList;

public class ReverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //non recursive
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rev;
    }
}
