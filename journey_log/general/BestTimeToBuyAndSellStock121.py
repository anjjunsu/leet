class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        cheapest = float('inf')
        max_profit = 0

        for price in prices:
            if price < cheapest:
                cheapest = price

            if max_profit < (price - cheapest):
                max_profit = price - cheapest    

        return max_profit
