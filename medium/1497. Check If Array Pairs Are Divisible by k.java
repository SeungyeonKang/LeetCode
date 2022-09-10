class Solution {
    //TC : O(n)
    public boolean canArrange(int[] arr, int k) {
        int[] kArr = new int[k];
        
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]%k;
            if(arr[i]>=0) kArr[arr[i]]++;
            else kArr[k+arr[i]]++;
        }
        
        if(kArr[0]%2 != 0) return false;
        
        for(int i=1;i<=k/2;i++){
            if(kArr[i] != kArr[k-i]) return false;
        }
        
        return true;
    }
}
