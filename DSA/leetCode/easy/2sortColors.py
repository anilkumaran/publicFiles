class Solution:
    def sortColors(self, nums) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        temp_nums = []
        print('nums', nums)
        for num in nums:
            if num == 0:
                print('B In 0 temp_nums', temp_nums)
                temp_nums.insert(0,num)
                print('A In 0 temp_nums', temp_nums)
            elif num == 1:
                print('B In 1 temp_nums', temp_nums)
                if len(temp_nums) == 1 :
                    mid = 1 if temp_nums[0] == 0 else 0
                else: 
                    mid = len(temp_nums)//2
                temp_nums.insert(mid,num)
                print('A In 1 temp_nums', temp_nums)
            else:
                print('B In 2 temp_nums', temp_nums)
                temp_nums.append(num)
                print('A In 2 temp_nums', temp_nums)
        # nums = [n for n in temp_nums]
        # nums = 'Hi'

        print('at end temp_nums', temp_nums)
        for i,n in enumerate(temp_nums):
            nums[i] = temp_nums[i]
        print('at end nums', nums)
        
        # return nums



s = Solution()
s.sortColors([0,0,1])
