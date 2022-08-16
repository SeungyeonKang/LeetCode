class Solution {
    //TC : O(n)
    //SC : O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n==1) return;
        
        int i = n-2;
        while(i>=0 && nums[i] >= nums[i+1]) i--;
        
        if(i>=0){
            int j = n-1;
            while(nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
        return;
        
    }
    
    public void swap (int[] nums, int k, int m) {
        int tmp = nums[k];
        nums[k] = nums[m];
        nums[m] = tmp;
    }
    
    public void reverse (int[] nums, int start) {
        int n = nums.length-1;
        if(start == n+1) return;
        
        while(start < n) {
            int tmp = nums[start];
            nums[start++] = nums[n];
            nums[n--] = tmp;
        }
    }
}
