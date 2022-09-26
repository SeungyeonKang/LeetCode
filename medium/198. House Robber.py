class Solution:
    #TC : O(n)
    #SC : O(n)
    def rob(self, nums: List[int]) -> int:
        #dp[x] = dp[x-2]+nums[x] or dp[x-3]+nums[x]
        dp = [0]*len(nums)
        n = len(nums)

        for idx in range(len(nums)) :
            if idx < 2 :
                dp[idx] = nums[idx]
            elif idx == 2 :
                dp[idx] = dp[0]+nums[2]
            else :
                dp[idx] = max(dp[idx-2]+nums[idx], dp[idx-3] + nums[idx])
    
        return max(dp[n-1], dp[n-2])
            
