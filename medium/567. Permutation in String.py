class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        '''
        s1 = "ab", s2 = "eidbaooo"
        
        TC:O(N)
        SC:O(1)
        '''
        
        counter = {}
        
        def checkZero(counter) :
            zero=True
            for x in counter.values() :
                if x != 0 :
                    zero = False
            return zero
        
        if len(s2) < len(s1) :
            return False
        
        for i in range(len(s1)) :
            counter[s1[i]] = 1 + counter.get(s1[i], 0)
            counter[s2[i]] = counter.get(s2[i], 0) -1 
            
        
        if checkZero(counter) : return True
        
        for i in range(len(s1),len(s2)) :
            counter[s2[i]] = counter.get(s2[i], 0) -1 
            counter[s2[i-len(s1)]] = counter.get(s2[i-len(s1)],0) +1
            
            if checkZero(counter) : return True
                
        return False
            
