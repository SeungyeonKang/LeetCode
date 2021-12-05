class Solution {
    public int maxProfit(int[] prices) {
        // 7 1 5 3 6 4
        //Time Complexity = O(n)
        //Space Complexity = O(1)
  
        int maxCur = 0;
        int result = 0;
        for(int i=1; i<prices.length; i++){
            maxCur = Math.max(0, maxCur + prices[i] - prices[i-1]);
            result = Math.max(result, maxCur);
        }
        return result;
    }
}
    

