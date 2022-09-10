class Solution {
//     public int longestConsecutive(int[] nums) {
//         //TC : O(logN)
//         if(nums==null || nums.length==0) return 0;
        
//         PriorityQueue<Integer> queue = new PriorityQueue<>();
        
//         for(int i=0;i<nums.length;i++){
//             queue.add(nums[i]);
//         }
//         int x = queue.poll();
//         int result = 0;
//         int cnt = 1;
        
//         while(!queue.isEmpty()) {
//             int y = queue.poll();
            
//             if(x==y) continue;
            
//             if(x+1 != y) {
//                 result = Math.max(result, cnt);
//                 cnt = 1;
//             }
//             else cnt++;
            
//             x = y;
//         }
        
//         result = Math.max(result, cnt);
//         return result;
//     }
    public int longestConsecutive(int[] nums) {
        //TC : O(n)
        int result = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)) {
                int y = nums[i]+1;
                while(set.contains(y)) {
                    y++;
                }
                result = Math.max(result, y-nums[i]);
            }
        }
        return result;
    }

}
