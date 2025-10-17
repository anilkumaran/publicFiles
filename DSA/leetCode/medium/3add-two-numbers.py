from typing import Optional

# Definition for singly-linked list.
'''
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


'''


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __repr__(self):
        return f"ListNode(val={self.val}, next={self.next})"

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        self.ll1, self.ll2 = l1, l2
        print(self.ll1)
        print(type(self.ll1))
        print(self.ll2)
        self.larray1 = self.extract_to_list(self.ll1)
        self.larray2 = self.extract_to_list(self.ll2)
        print(f"larray1 {self.larray1}")
        print(f"larray2 {self.larray2}")
        self.larray1.reverse()
        self.larray2.reverse()
        num1 = self.get_int_from_array(self.larray1)
        num2 = self.get_int_from_array(self.larray2)
        sum = [int(x) for x in list(''.join(reversed(str(num1 + num2))))]
        print(f"sum {sum}")
        return self.get_ListNode_from_arr(sum)

    def get_ListNode_from_arr(self, arr):
        dummy = ListNode(0)
        current = dummy
        for val in arr:
            current.next = ListNode(val)
            current = current.next
        print(f"result: {dummy.next}")
        print(type(dummy.next))
        return dummy.next

    def get_int_from_array(self, arr):
        return int(''.join([str(x) for x in arr]))

    def extract_to_list(self, ll):
        array = []
        current_node = ll
        while current_node.next:
            array.append(current_node.val)
            current_node = current_node.next
        array.append(current_node.val)
        print(array)
        return array

    def array_to_listnode(self, arr):
        dummy = ListNode(0)
        current = dummy
        for val in arr:
            current.next = ListNode(val)
            current = current.next
        return dummy.next
    
s = Solution()
print('Input')

a1 = [2,4,3]
a2 = [5,6,4]

# a1 = [0]
# a2 = [0]

a1 = [9,9,9,9,9,9,9]
a2 = [9,9,9,9]

l1 = s.array_to_listnode(a1)
l2 = s.array_to_listnode(a2)
s.addTwoNumbers(l1, l2)