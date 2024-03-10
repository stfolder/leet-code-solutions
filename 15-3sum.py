# https://leetcode.com/problems/3sum/description/


class Solution:

    
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i, j = 0, len(numbers) - 1
        result = []
        while i < j:
            sum = numbers[i] + numbers[j]
            if sum == target:
                result.append([numbers[i], numbers[j]])
                i += 1
                j -= 1
            elif sum < target:
                i += 1
            else:
                j -= 1
            while i < j and i > 0 and numbers[i] == numbers[i - 1]:
                    i += 1
            while i < j and j < (len(numbers) - 1) and numbers[j] == numbers[j + 1]:
                    j -= 1
        return result


    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = []
        for i in range(0, len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]: continue
            other_twos = self.twoSum(nums[i+1:], - nums[i])
            for two in other_twos:
                result.append([nums[i], *two])
        return result
