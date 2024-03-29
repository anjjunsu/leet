/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode* walker = head;
        ListNode* runner = head;

        while (runner != NULL && runner->next != NULL) {
            walker = walker->next;
            runner = runner->next->next;

            if (walker == runner) {
                walker = NULL;
                runner = NULL;
                return true;
            }
        }

        walker = NULL;
        runner = NULL;
        
        return false;
    }
};