# https://leetcode.com/problems/minimum-size-subarray-sum/description/


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        i, j = 0, 0
        sum = nums[0]
        l = len(nums)
        result = l + 1
        while True:
            if sum >= target:
                if (j - i + 1) < result:
                    result = j - i + 1
                i += 1
                sum -= nums[i - 1]
            elif sum < target and j < l - 1:
                j += 1
                sum += nums[j]
            else:
                break
        return result if result < l + 1 else 0
