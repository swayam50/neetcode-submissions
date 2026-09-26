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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)  return list2;
        if (list2 == null)  return list1;

        if (list2.val < list1.val)
            return mergeTwoLists(list2, list1);

        ListNode head = list1, prev = list1, l1 = list1.next, l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev = prev.next;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = prev.next;
                l2 = l2.next;
                prev.next = l1;
            }
        }

        if (l1 == null)
            prev.next = l2;

        return head;
    }
}