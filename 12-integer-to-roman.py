# https://leetcode.com/problems/integer-to-roman/description/


class Solution:
    def intToRoman(self, num: int) -> str:
        dig_map = {1: 'I', 5: 'V', 10: 'X', 50: 'L', 100: 'C', 500: 'D', 1000: 'M'}
        pos = 0 
        result = ''
        digit = num
        while pos < 4:
            pow10 = 10**pos
            if num < pow10: break
            digit = (num // pow10) % 10
            if digit == 0:
                pass
            if digit < 4:
                r_digit = dig_map[pow10]
                result = r_digit * digit + result
            elif digit < 9:
                r_digit_1 = dig_map[pow10]
                r_digit_5 = dig_map[pow10 * 5]
                if digit <= 5:
                    result = r_digit_1 * (5 - digit) + r_digit_5 + result
                else:
                    result = r_digit_5 + r_digit_1 * (digit - 5) + result
            else:
                r_digit_1 = dig_map[pow10]
                r_digit_10 = dig_map[pow10 * 10]
                result = r_digit_1 + r_digit_10 + result
            pos += 1
        return result
