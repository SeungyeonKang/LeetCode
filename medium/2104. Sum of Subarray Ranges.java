class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        int n = nums.length;
        int[] min_left = new int[n], min_right = new int[n];
        int[] max_left = new int[n], max_right = new int[n];
        Stack<int[]> min_ls = new Stack<>(), min_rs = new Stack<>();
        Stack<int[]> max_ls = new Stack<>(), max_rs = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            int count = 1;
            while(!min_ls.isEmpty() && min_ls.peek()[0] > nums[i]) {
                count += min_ls.pop()[1];
            }
            min_left[i] = count;
            min_ls.push(new int[]{nums[i], count});
            
            count = 1;
            while(!max_ls.isEmpty() && max_ls.peek()[0] < nums[i]) {
                count += max_ls.pop()[1];
            }
            max_left[i] = count;
            max_ls.push(new int[]{nums[i], count});
        }
        
        for(int i = n-1; i >= 0; i--) {
            int count = 1;
            while(!min_rs.isEmpty() && min_rs.peek()[0] >= nums[i]) {
                count += min_rs.pop()[1];
            }
            min_right[i] = count;
            min_rs.push(new int[]{nums[i], count});
            
            count = 1;
            while(!max_rs.isEmpty() && max_rs.peek()[0] <= nums[i]) {
                count += max_rs.pop()[1];
            }
            max_right[i] = count;
            max_rs.push(new int[]{nums[i], count});
        }
        
        long max = 0, min = 0;
        for(int i = 0; i < n; i++) {
            max = max + (long)nums[i] * max_left[i] * max_right[i];
            min = min + (long)nums[i] * min_left[i] * min_right[i];
        }
        
        return max - min;
    }
}
