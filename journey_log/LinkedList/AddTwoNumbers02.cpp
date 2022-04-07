/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* result = new ListNode();
        ListNode* node = result;
        int carry = 0;
        
        while (l1 != nullptr || l2 != nullptr) {
            int l1_val = 0;
            int l2_val = 0;
            int sum;
            
            if (l1 != nullptr) {
                l1_val = l1->val;
                l1 = l1->next;
            }
            
            if (l2 != nullptr) {
                l2_val = l2->val;
                l2 = l2->next;
            }
            
            sum = carry + l1_val + l2_val;
            
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            
            ListNode* curr = new ListNode(sum);
            node->next = curr;
            node = node->next;
        }
        
        if (carry == 1) {
            ListNode* msb = new ListNode(carry);
            node->next = msb;
        }
        
    return result->next;
    }
};
