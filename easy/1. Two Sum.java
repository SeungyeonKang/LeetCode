
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        target - i 가 배열에 있는 값인지 확인하면 됨.
        현재 인덱스 까지의 배열의 값들을 Map 자료구조에 <ㅍvalue, index> 형태로 넣어두면 O(1)에 확인할 수 있음
        Time : O(n)
        Space : O(n)
        */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])) return new int[] {map.get(target-nums[i]), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
