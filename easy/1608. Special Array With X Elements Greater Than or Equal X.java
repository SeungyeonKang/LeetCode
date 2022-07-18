class Solution {
    public int specialArray(int[] nums) {
        //TC : O(n)
        //SC : O(1)
        int len = nums.length;
        int[] number = new int[1001];
        int max = 0;
        
        for(int i=0;i<len;i++){
            number[nums[i]]++;
            max = nums[i] > max ? nums[i] : max;
        }
        
        int i = max;
        int x = 0;
        
        while(i>=x) {
            x+=number[i--];
        }
        
        if(x==i+1)
            return x;
        return -1;
    }
}
