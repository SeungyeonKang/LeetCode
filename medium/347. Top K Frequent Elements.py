class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        '''
        k= 1 or 0? 
        nums = [1], k=1 => [1]
        nums = [], k=1 => []
        1 <= nums.length <= 105
        nums[i] => integer boundary
        
        [1,2,2,3,4,1,1,1], k=2 => [1,2]
        
        num_dict = {{1:4}, {2:2}, {3:1}, {4:1}}
        
        //TC : O(NlogN)
        //SC : O(n)
        '''
        
        num_dict = dict()
        for num in nums :
            if num in num_dict :
                num_dict[num] += 1
            else :
                num_dict[num] = 1
        
        sorted_d = dict(sorted(num_dict.items(), key=operator.itemgetter(1),reverse=True))
        
        cnt = 0
        result = []
        
        for i in sorted_d :
            if cnt == k :
                break
            else : 
                result.append(i)
                cnt+=1
        
        return result
            
        
        
