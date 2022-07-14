class Solution {
    public int[] runningSum(int[] nums) {
        // SC(1)로 풀어보기
        
        //TC : O(n)
        //SC : O(1)
        
        int len = nums.length;
        for(int i=1;i<len;i++){
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
