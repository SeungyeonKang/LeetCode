class Solution {
    //TC : O(N^target)
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), target, candidates, 0);
        return result;
    }
    
    public void dfs(List<Integer> list, int x, int[] candidates, int idx) {
        if(x<0) return;
        
        if(x==0) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=idx;i<candidates.length;i++) {
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs(list, x-candidates[i], candidates, i);
            list.remove(list.size()-1);
        }
    }
}
