class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        '''
        
        s_dict = {{(0,0) : [5,3,6,9,8]}, {(0,2) : [7,1,9,5]}, {(0,2) : [6]}, ...}
        key : compress of i, j => i to i//3, j to j//3
        
        TC : O(n^2) n=9
        SC : O(n^2)
        '''
        
        #check column
        for j in range(len(board[0])) :
            check = []
            for i in range(len(board)) :
                if board[i][j] != "." :
                    if board[i][j] in check :
                        return False
                    else :
                        check.append(board[i][j])
                      
        s_dict = dict()            
        for i in range(len(board)) :
            check = []
            com_i = i//3
            
            for j in range(len(board[0])) :
                com_j = j//3
                if board[i][j] != "." :
                    if board[i][j] in check :
                        return False
                    else :
                        check.append(board[i][j])  

                    if (com_i,com_j) in s_dict :
                        if board[i][j] in s_dict[(com_i,com_j)] :
                            return False
                        else :
                            s_dict[(com_i,com_j)].append(board[i][j])
                    else :
                        s_dict[(com_i,com_j)] = [board[i][j]]
                        
        return True
                    
                
