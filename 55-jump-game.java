class Solution {
    public boolean canJump(int[] nums) {
        int p = nums.length - 2;
        int distance = 1;

        while (p >= 0) {
            if (nums[p] >= distance) {
                distance = 1;
            } else {
                distance++;
            }
            p--;
        }
        return distance == 1;
    }
}
