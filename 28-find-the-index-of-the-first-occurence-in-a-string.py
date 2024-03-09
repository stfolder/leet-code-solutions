# https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        i, j = 0, 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                j += 1
                if j == len(needle):
                    return i - j + 1
            else:
                i -= j
                j = 0
            i += 1
        return -1