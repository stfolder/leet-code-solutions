class Solution {

    int k = 0;
    int[] numbers;

    private int calcIndex(int i) {
        int l = numbers.length;
        return (k + i) % l;
    }

    private int getNR(int i) {
        return numbers[calcIndex(i)];
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            if (nums[left] < nums[right]) {
                break;
            }
            int mid = (left + right) / 2;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        k = left + 1;
        numbers = nums;

        left = 0;
        right = nums.length - 1;

        while (left < right - 1) {
            if (target == getNR(left)) {
                return calcIndex(left);
            }
            if (target == getNR(right)) {
                return calcIndex(right);
            }
            int mid = (left + right) / 2;
            if (target == getNR(mid)) {
                return calcIndex(mid);
            }

            if (target < getNR(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return getNR(left) == target 
            ? calcIndex(left) 
            : getNR(right) == target ? calcIndex(right) : -1;
    } 
}
