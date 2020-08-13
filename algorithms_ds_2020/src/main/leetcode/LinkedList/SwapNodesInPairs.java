package main.leetcode.LinkedList;

public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1, head);
        ListNode prev = node;
        while (prev.next != null && prev.next.next != null) {
            ListNode l1 = prev.next;
            ListNode l2 = prev.next.next;
            ListNode next = l2.next;
            l2.next = l1;
            l1.next = next;
            prev.next = l2;
            prev = l1;
        }
        return node.next;
    }
}
