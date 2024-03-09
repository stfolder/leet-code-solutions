# https://leetcode.com/problems/zigzag-conversion/description/


class Solution:
    def convert(self, s: str, numRows: int) -> str:
        result = ''
        l = len(s)
        colInterval = (numRows - 1) * 2
        if colInterval == 0: return s
        numCols = len(s) // colInterval + (1 if len(s) % colInterval != 0 else 0)
        for i in range(0, numRows):
            hasDiagonals = (i != 0) and (i != numRows - 1)
            diagonalOffset = (numRows - 1  - i) * 2
            for j in range(0, numCols):
                index = i + j * colInterval
                d_index = index + diagonalOffset
                if index < l:
                    result += s[index]
                if d_index > 0 and d_index < l and hasDiagonals:
                    result += s[d_index]
                
        return result