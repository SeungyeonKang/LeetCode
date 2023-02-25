class Solution:
    #TC : O(mn)
    #SC : O(mn)
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        left, right, top, bottom = 0, len(matrix[0])-1, 0, len(matrix)-1
        res = []
        
        while left<=right and top <= bottom :
            for x in range(left, right+1) :
                res.append(matrix[top][x])
            top+=1

            if top > bottom : break
            
            for x in range(top, bottom+1) :
                res.append(matrix[x][right])
            right-=1

            if left > right : break

            for x in reversed(range(left, right+1)) :
                res.append(matrix[bottom][x])
            bottom -=1

            if top > bottom : break

            for x in reversed(range(top, bottom+1)) :
                res.append(matrix[x][left])
            left+=1

        return res

