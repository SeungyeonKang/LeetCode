class Solution {
    //TC : O(n*n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), nums);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(result, list, nums);
            list.remove(list.size()-1);
        }
    }
}
