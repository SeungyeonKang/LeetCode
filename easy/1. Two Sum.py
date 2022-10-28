class Solution:
    #TC : O(n)
    #SC : O(1)
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        dic = dict()
        
        for i,x in enumerate(nums) :
            sub = target - x
            if sub in dic :
                return [dic[sub],i]
            else :
                dic[x] = i
        return None
