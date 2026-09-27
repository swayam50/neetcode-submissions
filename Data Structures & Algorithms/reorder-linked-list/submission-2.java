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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head, fast = head.next;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null);

        ListNode temp = slow.next;
        slow.next = null;

        ListNode head1 = head;
        ListNode head2 = reverseLinkedList(temp);

        ListNode l1 = head1, l2 = head2, curr = l1;
        while (l1 != null && l2 != null) {
            if (curr == l1) {
                l1 = l1.next;
                curr.next = l2;
            } else {
                l2 = l2.next;
                curr.next = l1;
            }
            curr = curr.next;
        }
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null, curr = head, next = curr.next;
        while (curr != null) {
            curr.next = prev;

            prev = curr;
            curr = next;
            next = next != null ? next.next : null;
        }
        return prev;
    }
}
