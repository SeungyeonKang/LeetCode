class Solution:
    #TC : O(n)
    #SC : O(n)
    def numDecodings(self, s: str) -> int:
        l = len(s)
        dp = [0]*(l+1)
        dp[l] = 1
        if s[l-1] == '0' : 
            dp[l-1] = 0
        else :
            dp[l-1] = 1
        
        for x in range(l-2, -1, -1) :
            if s[x] == '0' :
                dp[x] = 0
            else :
                dp[x] = dp[x+1]
                if s[x] == '1' :
                    dp[x] += dp[x+2]
                elif s[x] == '2' and s[x+1] <= '6' and s[x+1] >= '0' :
                    dp[x] += dp[x+2]
        return dp[0]
                
            
        
