class Solution {
    //My Solution : O(sqrt n) time, O(n) space   
    public int kthFactor(int n, int k) {
        int[] factors = new int[n];

        int idx = 0;
        int medium = (int) Math.sqrt(n);

        for(int i=1; i<=medium;i++){
            if(n%i==0) factors[idx++] = i;
        }
        
        int end;
        
        if(medium * medium == n) end = idx-1;
        else end =idx;

        for(int i=end-1; i>=0; i--){
            factors[idx++] = n / factors[i];
        }

        if(k > idx) return -1;
        else return factors[k-1];
    }
    
//Discussion : O(sqrt n) time, O(1) space   
//     public int kthFactor(int n, int k) {
        
//         for(int i = 1; i < Math.sqrt(n); ++i) {
//             if(n % i== 0 && --k == 0) return i;       
//         }
	                    
//         for(int i = (int) Math.sqrt(n); i >= 1; --i)  {
//             if(n % (n/i) == 0 && --k == 0) return n/i;    
//         }      
//         return -1;
//     }
      
}
