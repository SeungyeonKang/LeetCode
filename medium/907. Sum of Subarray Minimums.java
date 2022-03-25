class Solution {
    public int sumSubarrayMins(int[] arr) {
        //TC : O(n);
        //SC : O(n)
        int mod = (int)1e9 + 7;
        int len = arr.length;
        Stack<int[]> stack = new Stack<>();
        long sum = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        
        for(int i=0;i<len;i++){
            if(stack.isEmpty() || stack.peek()[0]< arr[i])  {
                stack.push(new int[]{arr[i],1});
                left[i] = 1;
            }
            else {
                int[] tmp = stack.pop();
                stack.push(new int[]{arr[i], tmp[1]+1});
                left[i] = tmp[1]+1;
            }
        }
        
        while(!stack.isEmpty()) {
            stack.pop();
        }
        
        for(int i = len-1; i>=0; i--) {
            if(stack.isEmpty() || stack.peek()[0] < arr[i]) {
                stack.push(new int[]{arr[i],1});
                right[i] = 1;
            } else {
               int[] tmp = stack.pop();
                stack.push(new int[]{arr[i], tmp[1]+1});
                right[i] = tmp[1]+1; 
            }
        }
        
        for(int i=0;i<len;i++){
            sum = sum + (long)(left[i]* right[i]*arr[i])%mod;
        }
        
        return (int)sum;
    }
}
