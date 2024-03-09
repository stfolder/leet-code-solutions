# https://leetcode.com/problems/roman-to-integer/description/


class Solution:
    def romanToInt(self, s: str) -> int:
        symbols = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        result = 0
        prev_symbol_value = 0
        for i in range(len(s) - 1, -1, -1):
            cur_symbol_value = symbols[s[i]]
            if cur_symbol_value >= prev_symbol_value:
                result += cur_symbol_value
                prev_symbol_value = cur_symbol_value
            else:
                result -= cur_symbol_value
                prev_symbol_value = 0
        return result