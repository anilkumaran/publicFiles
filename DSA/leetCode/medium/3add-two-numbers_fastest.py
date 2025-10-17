class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        current = dummy
        carry = 0
        
        while l1 or l2 or carry:
            total = carry + (l1.val if l1 else 0) + (l2.val if l2 else 0)
            
            current.next = ListNode(total % 10)
            current = current.next
            carry = total // 10
            
            if l1: l1 = l1.next
            if l2: l2 = l2.next
        
        return dummy.next
