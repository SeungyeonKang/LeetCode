class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
        1. check what is the nonflipable O -> 
        2. if 0 is adjacent with nonflipable 0 it should not be fliped.
        
        TC : O(mn)
        SC : O(mn)
        """
        
        def check(x,y) :
            if x<0 or x>=len(board) : return False
            if y<0 or y>=len(board[0]) : return False
            
            if board[x][y] == 'O' : return True
            return False
        
        queue = []
        visited = [[0 for y in range(len(board[0]))] for x in range(len(board))] 
        #initial condition
        for x in range(len(board)) :
            for y in range(len(board[0])) :
                if (x == 0 or y == 0 or x==len(board)-1 or y==len(board[0])-1) and board[x][y] == 'O':
                    queue.append([x,y])
                    visited[x][y] = 1
                    
        while len(queue) != 0 :
            x,y = queue.pop()
            #check adjacent
            x_helper = [0,1,0,-1] 
            y_helper = [1,0,-1,0]
            for i in range(4) :
                if check(x+x_helper[i], y+y_helper[i]) and visited[x+x_helper[i]][y+y_helper[i]] == 0:
                    visited[x+x_helper[i]][y+y_helper[i]] = 1
                    queue.append([x+x_helper[i], y+y_helper[i]])
                    
        for x in range(len(board)) :
            for y in range(len(board[0])) :
                if board[x][y] == 'O' and visited[x][y] == 0 :
                    board[x][y] = 'X'
        return board
                    
       
                    
        
