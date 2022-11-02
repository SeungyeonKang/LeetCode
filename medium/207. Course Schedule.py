class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        '''
        prerequisites => 0 => [0,1]
        
        Topological Sort => DFS ==> TC : O(V+E)
        
        graph
        graph[0] = [1]
        graph[1] = [2,3,4]
        
        dfs  :
        - if current courses has already been visited => There is a cycle 
            return False
        - if current course is avaliable course => return True
        
        - check the graph and check each prerequisites => all is True, return True
        '''
        
        graph = [[] for i in range(numCourses)] #O(N)
        visited = [ 0 for i in range(numCourses)] #1:available course,  -1 : not available course #O(N)
        
        def dfs(course) :
            if visited[course] == 1 :
                return True
            elif visited[course] == -1 :
                return False
                
            visited[course] = -1
            
            for x in graph[course] :
                if dfs(x) == False :
                    return False
            
            visited[course] = 1
            return True
        
        for x, y in prerequisites :
            graph[x].append(y)
        
        for course in range(numCourses) :
            if dfs(course) == False : 
                return False
        return True
        
        
