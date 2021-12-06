//53. Maximum Subarray(E)
class Solution {
    
    // -2, 1, -3, 4, -1, 2, 1, -5, 4
    /*
        dp[0] = nums[i];
        dp[i] // i번쨰 인덱스를 포함한 최대 subArray
        dp[i] = Math.max(dp[i-1]+nums[i], nums[i])
        result = Math.max(dp[i], result);
        
        (ex) 
        dp[0] = -2, dp[1] = 1, dp[2] = -2, dp[3] = 4, dp[4] = 3, 
        dp[5] = 5, dp[6] = 6, dp[7] = 1, dp[8] = 5
      
        Time Complexity : O(n)
        Space Complexity : O(n)
        
        *개선 dp[i-1]에 대해서만 접근을 하고 있기 떄문에 preSum을 유지하고 있으면 마찬가지로 해결 가능
        Time Complexity : O(n)
        Space Complexity : O(1)
    */
    
    public int maxSubArray(int[] nums) {
        
        int preSum;
        int result = nums[0];
        preSum = nums[0];
        
        for(int i=1; i<nums.length; i++){
            preSum = Math.max(preSum + nums[i], nums[i]);
            result = Math.max(result, preSum);
        }
        
        return result;
    }
    
    /*public int maxSubArray(int[] nums) {
        //dp[x] : [0,x] 중 x 를 포함하는 subArray의 최대값
        int[] dp = new int[nums.length];
        
        //기저조건
        dp[0]=nums[0];
        int result = dp[0];
        
        for(int i=1; i<nums.length; i++){
            int tmp = dp[i-1]+nums[i];
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        
        return result;   
    }*/
}

