import javax.management.ListenerNotFoundException;

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
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }

        return prevNode;
    }

    public ListNode recursiveReverse(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode node, ListNode prevNode) {
        if (node == null) {
            return prevNode;
        }

        ListNode nextNode = node.next;
        node.next = prevNode;
        prevNode = node;
        
        return helper(nextNode, prevNode);
    }
}