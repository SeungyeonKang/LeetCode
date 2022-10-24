class Solution:
    #TC : O(n)
    #SC : O(1)
    def minIncrementForUnique(self, nums: List[int]) -> int:
        max_n = -1
        move = 0
        for x in sorted(nums) :
            if max_n < x :
                max_n = x
            else :
                max_n+=1
                move += max_n - x
        return move
                
