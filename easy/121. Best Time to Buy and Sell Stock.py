class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        '''
        prices = [7,1,5,3,6,4] => 5
        prices = [7] => 0
        prices = [4,3,2,1] => 0
        
        TC:O(n)
        SC:O(1)
        '''
        
        min_price = prices[0]
        res = 0
        
        for price in prices :
            res = max(price - min_price, res)
            min_price = min(price, min_price)
            
        return res
