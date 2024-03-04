# https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i, j = 0, 0
        
        while j < len(nums):
            prev = nums[j]
            while j < len(nums) and nums[j] == prev:
                j += 1
            nums[i] = prev
            i += 1
        return i