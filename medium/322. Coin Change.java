class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[x] = x가 될 수있는 최소 동전의 갯수
        //dp[x] = Math.min(dp[x-coin])+1
        //Time Complextiy : O(mn) n : amount, m : coins
        //Space Complexity : O(n)
        
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        int sum = 1;
        
        while(sum<=amount) {
            int min = -1;
            
            for(int coin: coins) {
                if(sum>=coin && dp[sum-coin]!=-1) {
                    int tmp = dp[sum-coin]+1;
                    min = min<0 ? tmp : (tmp < min ? tmp : min);
                }
            }
            dp[sum++] = min;
        }
        return dp[amount];
    }
}
