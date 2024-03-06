# https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i, j = 0, 0

        while j < len(nums):
            prev = nums[j]
            prev_count = 1
            while j < len(nums) and nums[j] == prev:
                if prev_count <= 2:
                    nums[i] = nums[j]
                    i += 1
                    prev_count += 1
                j += 1
        return i