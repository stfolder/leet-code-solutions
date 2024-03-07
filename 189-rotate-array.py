# https://leetcode.com/problems/rotate-array/description/


class Solution:


    def reverse_list(self, nums: List[int], start: int, end: int):
        i, j = start, end
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1


    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l = len(nums)
        if l <=1: return
        k = k % l
        if k == 0: return

        self.reverse_list(nums, 0, len(nums) - 1)
        self.reverse_list(nums, 0, k - 1)
        self.reverse_list(nums, k, len(nums) - 1)