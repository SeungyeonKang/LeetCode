class Solution {
    //TC : O(n)
    //SC : O(n)
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums1) {
            if(map.containsKey(i)) {
                map.put(i,map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int j : nums2) {
            if(map.containsKey(j)) {
                result.add(j);
                if(map.get(j) > 1) map.put(j, map.get(j) - 1);
                else map.remove(j);
            } 
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}
