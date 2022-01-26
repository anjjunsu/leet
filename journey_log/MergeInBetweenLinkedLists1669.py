# Definition for singly-linked list.
from platform import node


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        
        # First, get node (a-1)th of list1
        node_start = list1
        for i in range(a - 1):
            node_start = node_start.next

        # Then, get node (b+1)th of list1
        node_end = list1
        for j in range(b+1):
            node_end = node_end.next

        # Then, get last node of list2
        list2_last = list2
        while (list2_last.next != None):
            list2_last = list2_last.next

        # Now, append list2 between after list1's (a-1)th node and before (b+1)th node
        node_start.next = list2
        list2_last.next = node_end

        return list1        
