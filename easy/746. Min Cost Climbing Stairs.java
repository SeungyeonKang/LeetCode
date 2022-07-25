class Solution {
    //TC : O(n)
    //SC : O(1)
     public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev, prev2;
        
        //기저조건
        if(n<2) return Math.min(cost[0], cost[1]);
        
        //dp[i] = Math.min(dp[i-2] +cost[i], dp[i-1]+cost[i]);
    
        for(int i = 2; i<n; i++){
            int cur = Math.min(prev2+cost[i], prev+cost[i]); 
            prev2 = prev;
            prev = cur;
        }
        
        return Math.min(prev2, prev);
    }
}
