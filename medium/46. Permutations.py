class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        '''
        nums <-- only consist of the numbers? -> negative,positive,0 / duplicates?
        nums.length -> can be blank?
        
        output = 2d array
        
        TC:O(n!)
        SC : O(n)
        '''
        def dfs(path, max_len)  :
            if len(path) == max_len :
                res.append(path)
            
            for x in nums :
                if x not in path :
                    dfs(path+[x],  max_len)
            
        res = []
        
        for x in nums :
            dfs([x], len(nums))
        return res
    
    
    
        
        
