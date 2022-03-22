class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        /*
        input : 
        nums, 
        k = odd numbers count
        nice = subarray (have subarray with k odd numbers)
        
        #make it clear
        1<=nums.length<=50000
        1<=nums[i]<=10^5
        1<=k<=nums.length
        
        #ideas
        1. brute force
         for(i=0; to nums.len)  => O(n^2) ==> BAD!!
            int cnt=0
            for(j=i to nums.len)
                if(nums[j] == odd) cnt++
                if(cnt==k) nice++
                
        2. sliding window
        l=0, r=0
        - while()
            - check if it's odd
                - add cnt+1
            - check if cnt == k
                - if nums[l++] == odd
                    cnt--
                    
        **CAREFUL : Subarray Count ** 
                    
        TC : O(n)
        SC : O(1);
        */
        
        int l = 0, r = 0;
        int count = 0; //the number of odds
        int cnt = 0;
        int nice=0; // ths number of nice subarray
        
        while(r < nums.length) {
            if(nums[r]%2 == 1) {
                cnt++;
                count = 0;
            }
            while(cnt == k) {// nice subarray 
                if(nums[l]%2==1) cnt--;
                count++;
                l++;
            }
            r++;
            nice += count;
        }
        
        return nice;
    }
}
