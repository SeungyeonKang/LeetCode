class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        #TC : O(min(m,n)) 
        #SC : Space O(k) where k is the number of intersections
        
        i1,i2 = 0,0
        res = []

        while i1<len(firstList) and i2<len(secondList) :
            s1,e1,s2,e2 = firstList[i1][0], firstList[i1][1], secondList[i2][0], secondList[i2][1]

            if e1 < s2 :
                i1+=1
            elif e2 < s1 :
                i2+=1
            else :
                start = max(s1,s2)
                end = min(e1,e2)
                res.append([start,end])
                if e1<e2 :
                    i1+=1
                else :
                    i2+=1
        return res
