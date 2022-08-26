class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        list_sum = sum(nums)
        left_sum = 0

        for i, num in enumerate(nums):
            if left_sum == (list_sum - num - left_sum):
                return i
            
            left_sum += num

        return -1
                