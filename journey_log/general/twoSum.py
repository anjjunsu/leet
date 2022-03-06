from typing import List

class Solution:
    def twoSum(nums: List[int], target: int) -> List[int]:
        diff = {}

        for i in range(len(nums)): 
            d = target - nums[i]

            if d in diff.keys():
                return [diff.get(d), i]
            
            diff[nums[i]] = i
        
        raise ValueError("No solution")



# Test 1: expected output = [0, 1]
nums1 = [2, 7, 11, 15]
target1 = 9
out1 = Solution.twoSum(nums1, target1)
print(out1)

