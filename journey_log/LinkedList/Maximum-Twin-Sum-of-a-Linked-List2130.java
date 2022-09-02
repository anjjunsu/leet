import java.util.HashMap;
import java.util.Map;

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
    public int pairSum(ListNode head) {
        
        Map<Integer, Integer> sumOfTwins = new HashMap<>();
        int length = 0;
        int max = Integer.MIN_VALUE;

        // get length
        ListNode node = head;

        while (node != null) {
            length ++;
            node = node.next;
        }

        node = head;
        int idx = 0;
        while (node != null) {
            if (idx < (length / 2)) {
                sumOfTwins.put(idx, node.val);
            } else {
                int twinIdx = length - idx - 1;
                int twinSum = sumOfTwins.get(twinIdx) + node.val;
                sumOfTwins.put(twinIdx, twinSum);
            }

            node = node.next;
            idx++;
        }

        for (Integer sum : sumOfTwins.values()) {
            if (sum > max)
                max = sum;
        }

        return max;
    }
}
