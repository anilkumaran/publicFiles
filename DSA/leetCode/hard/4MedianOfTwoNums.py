
from typing import List
class Solution:
    avg = lambda self, n1, n2: (n1 + n2)/2 
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        merged_arr = nums1 + nums2
        merged_arr.sort()
        merged_arr_len = len(merged_arr)
        return merged_arr[int((merged_arr_len + 1)/2)-1] if merged_arr_len %2 != 0 else self.avg(merged_arr[int((merged_arr_len/2))-1],merged_arr[int((merged_arr_len/2))])

s = Solution()
print(s.findMedianSortedArrays([1,3], [2,4,5]))
