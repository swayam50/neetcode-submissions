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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode leader = head;
        while (n-- > 0)
            leader = leader.next;

        ListNode dummy = new ListNode(-1, head);

        ListNode follower = dummy;
        while (leader != null) {
            leader = leader.next;
            follower = follower.next;
        }

        follower.next = follower.next.next;

        return dummy.next;
    }
}
