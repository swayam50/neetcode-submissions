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
        List<Integer> nodes = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            nodes.add(temp.val);
            temp = temp.next;
        }

        int i = 0, j = nodes.size() - 1;
        temp = head;
        while (temp != null) {
            temp.val = nodes.get(i++);
            temp = temp.next;
            if (temp != null) {
                temp.val = nodes.get(j--);
                temp = temp.next;
            }
        }
        
    }
}
