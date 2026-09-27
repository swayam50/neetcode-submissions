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
        List<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        int ind = nodes.size() - n;
        ListNode dummy = new ListNode(-1), last = dummy;
        for (int i = 0; i < nodes.size(); i++)
            if (i != ind) {
                last.next = new ListNode(nodes.get(i));
                last = last.next;
            }

        return dummy.next;
    }
}
