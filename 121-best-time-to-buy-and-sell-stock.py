# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        chipest = prices[0]
        for day in range(1, len(prices)):
            cur_price = prices[day]
            cur_profit = cur_price - chipest
            if cur_profit > profit:
                profit = cur_profit
            if cur_price < chipest:
                chipest = prices[day]
        return profit
