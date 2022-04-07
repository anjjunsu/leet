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
        ListNode result_head = new ListNode();   // dummy head node
        ListNode result = result_head;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int sum = 0;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carry;
            
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            
            ListNode curr = new ListNode(sum);
            
            result.next = curr;
            result = result.next;
        }
        
        if (carry == 1) {
            ListNode msd = new ListNode(carry);
            result.next = msd;
        }
        
        return result_head.next;
    }
}
