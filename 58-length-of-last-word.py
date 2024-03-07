# https://leetcode.com/problems/length-of-last-word/description/


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        char_counter = 0
        for i in range(len(s) - 1, -1, -1):
            if s[i] != ' ':
                char_counter += 1
            elif char_counter > 0:
                break
        return char_counter
