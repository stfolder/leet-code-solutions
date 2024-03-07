# https://leetcode.com/problems/majority-element/description/


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        occurencies = dict({})
        for element in nums:
            qty = occurencies[element] if element in occurencies else 0
            qty += 1
            occurencies[element] = qty
            if qty > len(nums) / 2:
                return element
        return None
