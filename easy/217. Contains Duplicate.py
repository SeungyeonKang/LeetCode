class Solution:
    #TC:O(n) SC:O(n)
    def containsDuplicate(self, nums: List[int]) -> bool:
        result = set()

        for num in nums :
            result.add(num)

        if len(result) == len(nums) :
            return False
        else :
            return True
