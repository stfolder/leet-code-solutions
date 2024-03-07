# https://leetcode.com/problems/reverse-words-in-a-string/description/


class Solution:
    def reverseWords(self, s: str) -> str:
        result = ''
        word_start = None
        for i in range(0, len(s) + 1):
            if i == len(s) or s[i] == ' ':
                if word_start != None:
                    detected_word = s[word_start:i]
                    result = detected_word + ' ' + result
                    word_start = None
            elif word_start == None:
                word_start = i
        return result[0:-1]
