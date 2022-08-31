class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //input : array, unique element, 1<=nums.length<=10, -10 <= nums[i] <= 10
        //output List<List<Integer>>
        
        //[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for(int i=0;i<nums.length; i++) {
            int size = result.size();
            for(int j=0;j<size;j++){
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}
