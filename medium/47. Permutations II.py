class Solution:
    #TC : O(N*N!)
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        numDict = dict()
        self.numLen = len(nums)
        self.res = []

        for x in nums :
            if x not in numDict :
                numDict[x] = 1
            else :
                numDict[x] += 1
        self.dfs(numDict, [])
        return self.res
        
    def dfs(self, numDict, path) :
        if len(path) == self.numLen :
            self.res.append(path[:])
            return
        
        for x in numDict :
            if numDict[x] > 0 :
                path.append(x)
                numDict[x]-=1
                self.dfs(numDict, path)
                numDict[x]+=1
                path.pop()
        
