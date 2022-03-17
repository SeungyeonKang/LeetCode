class Solution {
    public int[] shuffle(int[] nums, int n) {
        /*
        [2,5,1,3,4,7] -> [2,3,5,4,1,7]
        [x1,x2,x3,y1,y2,y3] -> [x1,y1,x2,y2,x3,y3]
        */
        int[] res = new int[n*2];
        for(int i=0, j=n, idx = 0 ; idx < n*2; i++, j++){
            res[idx++] = nums[i];
            res[idx++] = nums[j];
        }
        
        return res;
        
    }
}
