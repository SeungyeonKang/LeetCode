class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        '''
        Topological Sort
        - graph[course] = [prerequisites]
        - visited[] -> TO check current course is takable course or not
        - res[]
        
        TC : O(V+E)
        SC : O(V+E)
        '''
        graph = [[] for i in range(numCourses)]
        visited = [0 for i in range(numCourses)]
        res = []
        
        def dfs(course) :
            if visited[course] == 1 :
                return True
            if visited[course] == -1 :
                return False
            
            visited[course] = -1
            for x in graph[course] :
                if dfs(x) == False :
                    return False
            res.append(course)
            visited[course] = 1
            
            return True
        
        for x,y in prerequisites :
            graph[x].append(y)
        
        for x in range(numCourses) :
            if dfs(x) == False :
                return []
        return res
    
