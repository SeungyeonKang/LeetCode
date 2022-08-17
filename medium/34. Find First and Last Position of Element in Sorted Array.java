class Solution {
    //TC : O(logN)
    //SC : O(1)
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int first=-1, second=-1;
        
        //find last index of target
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(nums[mid] <= target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
            if(nums[mid] == target) second = mid;
        }
        
        start = 0;
        end = nums.length-1;
        
        //find first index of target
        while(start <= end) {
            int mid = (start  + end) / 2;
            if(nums[mid] < target) {
                start = mid +1;
            } else {
                end = mid-1;
            }
            if(nums[mid] == target) first = mid;
        }
        
        return new int[]{first, second};
    }
}
