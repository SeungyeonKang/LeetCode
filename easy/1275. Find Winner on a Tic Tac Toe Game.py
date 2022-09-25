#TC(mn) : m is the len(moves), n : length of board -> '3' in this question
#SC(n^2) 

class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        n = 3
        board = [[0 for i in range(n)] for j in range(n)]

        for x in range(len(moves)) :
            #check who's win everytime when the new input is came.
            row = moves[x][0]
            col = moves[x][1]
            if x%2 == 0 :
                board[row][col] = 'X'
                if self.didWin(board, row, col, 'X', n) : return 'A'
            else :
                board[row][col] = 'O'
                if self.didWin(board, row, col, 'O', n) : return 'B'
            
        if len(moves) == n*n :
            return "Draw"
        else : 
            return "Pending"
            
    def didWin(self, board, row, col, player, n) :
        didPlayerwin = True
        for x in range(n) :
            if board[row][x] != player :
                didPlayerwin = False
        
        if didPlayerwin : return True
        
        didPlayerwin = True
        
        for x in range(n) :
            if board[x][col] != player :
                didPlayerwin = False
        
        if didPlayerwin : return True
        
        if row == col : 
            didPlayerwin = True
            for x in range(n) :
                if board[x][x] != player :
                    didPlayerwin = False
            if didPlayerwin : return True
        
        if col == n-row-1 :
            didPlayerwin = True
            for x in range(n) :
                if board[x][n-x-1] != player :
                    didPlayerwin = False
            if didPlayerwin : return True
        
        return False
