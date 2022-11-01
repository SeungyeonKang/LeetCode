class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        '''
        TC : O(n)
        SC : O(1)
        '''
        
        s = 0
        n = len(numbers)-1
        
        while s < n and n < len(numbers) :
            t_sum = numbers[s] + numbers[n] 
            
            if t_sum == target :
                return [s+1,n+1]
            elif t_sum > target :
                n-=1
            else :
                s+=1
        return -1
