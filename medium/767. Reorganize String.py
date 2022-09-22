#TC : O(n)
#SC : O(n)
class Solution:
    def reorganizeString(self, s: str) -> str:
        
        alphabet = dict()
        s_len = len(s)
        
        for ch in s :
            if ch in alphabet :
                alphabet[ch] += 1
            else :
                alphabet[ch] = 1
            
        if s_len %2 == 0 :
            max_cnt = s_len/2
        else : 
            max_cnt = s_len/2 + 1
        
        for key in alphabet :
            if alphabet[key] > max_cnt  :
                return ""

        sorted_d = dict(sorted(alphabet.items(), key=lambda item: item[1], reverse=True))
        result = [None] * s_len
        index = 0
        
        for x in sorted_d : 
            cnt = alphabet[x]
            while cnt > 0 :
                if index >= s_len :
                    index = 1
                result[index] = x
                index += 2
                cnt -= 1
                
        result_str = ""
        for x in range(s_len) :
            result_str += result[x]
            
        return result_str
            
        
