class Solution {
    public int pivotIndex(int[] nums) {
        /*pivot index : 
         - the sum of the left side elements of the pivot index and 
           the sum of the right side elements of the pivot are same.
        */
        
        // left sum of the pivot : 0  1 8  11 17 22
        // right sum of the pivot : 27 20 17 11 6  0  

        
        int len = nums.length;
        int left=0, right, sum=0;
        
        for(int i=0;i<len;i++){
            sum += nums[i];
        }
        
        right = sum;
        
        for(int i=0;i<len;i++){
            right -= nums[i];
            if(right == left)   return i;
            left += nums[i];
        }
        return -1;
        
        //TC : O(n)
        //SC : O(1)
    }
}
