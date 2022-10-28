class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        char_s = []
        for c in s :
            char_s.append(c)
            
        for c in t :
            if c in char_s :
                char_s.remove(c)
            else :
                return False
        if len(char_s) == 0 :
            return True
        else :
            return False
