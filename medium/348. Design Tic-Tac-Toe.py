class TicTacToe:

    def __init__(self, n: int):
        self.row, self.col, self.diag, self.anti_diag, self.n = [0]*n, [0]*n, 0, 0, n

    def move(self, row: int, col: int, player: int) -> int:
        offset = player * 2 - 3 # player1 = -1, player2 = 1
        self.row[row] += offset
        self.col[col] += offset
        if row == col :
            self.diag += offset
        if row + col == self.n - 1  :
            self.anti_diag += offset
        #If offset == n, -n, it means the row/col/diag filled with one player's mark
        if self.n in [self.row[row], self.col[col], self.diag, self.anti_diag] :
            return 2
        if -self.n in [self.row[row], self.col[col], self.diag, self.anti_diag] : 
            return 1
        return 0
        


# Your TicTacToe object will be instantiated and called as such:
# obj = TicTacToe(n)
# param_1 = obj.move(row,col,player)
