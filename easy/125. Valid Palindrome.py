class Solution:
    def isPalindrome(self, s: str) -> bool:
        '''
        s = A, ma ma! => true
        s = " " => true
        
        1) iterate and replace lowercase to uppercase and remove all non-aplhanumeric value
        
        TC : O(n)
        SC : O(1)
        '''
        
        front, end = 0, len(s)-1
        
        while front<=end :
            if not s[front].isalnum():
                front+=1
                continue
            
            if not s[end].isalnum():
                end-=1
                continue
            
            if s[front].lower()!=s[end].lower() :
                return False
            
            front+=1
            end-=1
            
        return True
                
        
        
