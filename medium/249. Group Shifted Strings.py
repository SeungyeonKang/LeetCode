class Solution:
    #TC : O(NM)
    #SC : O(N)
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        sd = {} #{ {[1, 25]:[aba,cdc]}, [1,2,1]:[abde]}
        
        for s in strings : #O(n), n= # of str in list
            tmp = []
            prev = None
            for c in s : #O(m), m=maximun length of str in the list
                if prev != None: 
                    sub = ord(c) - ord(prev)
                    if sub < 0 : sub+=26
                    tmp.append(sub)
                prev = c

            t_tmp = tuple(tmp)
            if t_tmp not in sd :
                sd[t_tmp] = [s]
            else :
                sd[t_tmp].append(s)
        
        #print(sd)
        result = []
        for x in sd :
            result.append(sd[x])
        return result

