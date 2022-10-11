class Solution:
    #TC : O(n)
    #SC : O(n)
    
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for token in tokens :
            if token in ["+", "-","*","/"] :
                y = stack.pop()
                x = stack.pop()
                print(x,token,y)
                if token == "+" :
                    x = int(x) + int(y)
                elif token == "-" :
                    x = int(x)-int(y)
                elif token == "*" : 
                    x = int(x) * int(y)
                elif token == "/" :
                    x = int(x) / int(y)
                stack.append(int(x))
            else :
                #print(token)
                stack.append(token)
            
        return stack.pop()
