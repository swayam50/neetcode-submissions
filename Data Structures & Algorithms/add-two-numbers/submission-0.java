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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        
        ListNode head = new ListNode(), last = head;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (carry ? 1 : 0);
            l1 = l1.next;
            l2 = l2.next;

            carry = sum > 9;
            last.next = new ListNode(sum % 10);
            last = last.next;
        }
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : l2.val) + (carry ? 1 : 0);
            carry = sum > 9;
            last.next = new ListNode(sum % 10);
            last = last.next; 

            if (l1 != null)
                l1 = l1.next;
            else
                l2 = l2.next;
        }
        if (carry) {
            last.next = new ListNode(1);
            last = last.next;
        }

        return head.next;
    }
}
