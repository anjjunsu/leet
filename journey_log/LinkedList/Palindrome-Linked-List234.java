import java.util.ArrayList;
import java.util.List;

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
    public boolean isPalindrome(ListNode head) {

        if (head == null) 
            return false;

        List<Integer> copy = new ArrayList<>();

        while (head != null) {
            copy.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = copy.size() - 1;

        while (left < right) {
            if (copy.get(left) != copy.get(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
