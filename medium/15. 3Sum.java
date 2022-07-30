class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //TC : O(n^2)
        //SC : O(n)
        Set<List<Integer>> result = new HashSet<>(); //결과가 중복되어서는 안되므로 set에다 넣고 추후 list로 변환하기
        if(nums.length==0) return new ArrayList<>(result);
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1; 
            while(j<k){
                int tmp = nums[i] + nums[j] + nums[k];
                if(tmp==0) result.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if(tmp>0) k--;
                else j++;
            }
        }
        return new ArrayList<>(result);
    }
}
