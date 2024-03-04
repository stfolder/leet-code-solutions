# https://leetcode.com/problems/remove-element/description/


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if len(nums) == 0: return 0
        left, right = 0, len(nums) - 1
        while (left < right):
            if (nums[left] == val):
                while (nums[right] == val and left < right):
                    right -= 1
                if (nums[right] == val):
                    break
                nums[left] = nums[right]
                nums[right] = val
                right -= 1
            left += 1
        return left if nums[left] == val else left + 1