class Solution:
    #TC : O(2^2N) = O(4^n) -> assume we have 2 options and it is repeated 2n times
    def generateParenthesis(self, n: int) -> List[str]:
        self.res = []

        def dfs(n, open, close, path) :
            #print(path)
            if len(path) == n*2 :
                self.res.append(path[:])
                return

            if open < n :
                path = ''.join((path,'('))
                dfs(n, open+1, close, path)
                path = path[:-1]
            
            if close < open :
                path = ''.join((path,')'))
                dfs(n, open, close+1, path)
                path = path[:-1]

        dfs(n, 0, 0, "")
        return self.res
        
            

        
