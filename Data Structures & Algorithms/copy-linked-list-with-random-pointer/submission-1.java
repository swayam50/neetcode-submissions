/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        Node head1 = head, head2 = head.next;
        Node l1 = head1, l2 = head2;
        while(l1 != null) {
            if (l1.next == l2) {
                l1.next = l2.next;
                l1 = l2.next;
            } else {
                l2.next = l1.next;
                l2 = l1.next;
            }
        }
        l2.next = null;

        return head2;
    }
}
