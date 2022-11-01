class Solution:
    def maxArea(self, height: List[int]) -> int:
        '''
        height[i] can be 0 ? -> x
        height[i] -> 1000
        0 < height[i] < 1000
        1 < height.length < 1000
        
        [1,8,6,2,5,4,8,3,7] => 49
        brute force -> O(n^2)
        
        min(height[first], height[second]) * (second - first)
        
        TC : O(n)
        SC : O(1)
        '''
        
        l, r = 0, len(height)-1
        
        res = 0
        while l < r :
            cur = min(height[l], height[r]) * (r - l)
            res = max(res, cur)
            
            if height[l] < height[r] :
                l+=1
            else :
                r-=1
        return res
