class Solution {
    public int[] plusOne(int[] digits) {
        boolean hasOneToAdd = true;
        int pointer = digits.length - 1;
        while (hasOneToAdd && pointer >= 0) {
            int increased = digits[pointer] + 1;
            digits[pointer] = increased % 10;
            hasOneToAdd = increased > 9;
            pointer--;
        }

        if (pointer < 0 && hasOneToAdd) {
            int[] result = new int[digits.length + 1];
            for (int i = digits.length - 1; i > 0; i--)
                result[i + 1] = digits[i];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }

    }
}
