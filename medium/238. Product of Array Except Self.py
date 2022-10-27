class Solution:
    def productExceptSelf(self, A: List[int]) -> List[int]:
        '''
        1) Clarify the question
        2) Think about the edge case
        3) Describe solution + Think about better solution
        4) Implement the code
        5) Describe TC and SC
        6) Testing

        element[i] = the product of all element except element[i]

        - range of values? -> positive, negative, zero
        - time limit? -> Not really
        - all integers? or String? -> Integer

        [1,2,3,4] -> [24, 12, 8, 6]
        [-1, -2, -3, -4] -> [-24, -12, -8, -6]
        [0,1,2,3] -> [12, 0, 0, 0]
        [] -> []
        [4] -> [4] 

        2nd for loop -> not good time complexity = O(n^2)

        2 array -> left[], right[] => SC : O(n)
        left[i] = left[i-1] * arr[i-1]
        right[i] = right[i+1] * arr[i+1]
        result[i] = left[i] * right[i]
        
        1 variables -> prev, post
        prev = prev result of product
        post = post result of product
        
        TC : O(n), SC : O(1)
        '''

        # if len(A) == 0 :
        #     return []
        # if len(A) == 1  :
        #     return A

        result = [1]*len(A) 
        prev, post = 1, 1

        for i in range(len(A)) :
            result[i] *= prev
            prev *= A[i]
        for i in reversed(range(len(A))) :
            print(i)
            result[i] *= post
            post *= A[i]

        return result
