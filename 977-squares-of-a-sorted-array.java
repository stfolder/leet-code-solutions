// https://leetcode.com/problems/squares-of-a-sorted-array/description/


class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0, r = nums.length - 1;
        int l2 = nums[l] * nums[l], r2 = nums[r] * nums[r];
        int idx = nums.length - 1;

        while(idx >= 0) {
            if (l2 >= r2) {
                result[idx--] = l2;
                l++;
                if (l < nums.length) {
                    l2 = nums[l] * nums[l];
                }
            } else {
                result[idx--] = r2;
                r--;
                if(r>=0) {
                    r2 = nums[r] * nums[r];
                }
            }
        }

        return result;
    }
}