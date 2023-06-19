class Solution:
    def earliestAcq(self, logs: List[List[int]], n: int) -> int:
        '''
        [0] -> [0,1,5]
        [2] -> [2,3,4]
        0:0, 1:0, 5:0, 2:2, 3:2, 4:2
        [0] -> [0,1,2,3,4,5] =6

        union find
        '''
        ufd, ufa = {}, {}

        def find(x) :
            if x in ufd :
                return ufd[x]
            else :
                ufd[x] = x
                ufa[x] = [x]
                return x

        def union(a, b) :
            target = ufa[b]
            dest = ufa[a]
            for x in target :
                ufd[x] = a
                dest.append(x)
            ufa.pop(b)
        
        logs = sorted(logs)
        
        for timestamp, a, b in logs :
            ap = find(a)
            bp = find(b)
            if ap == bp : continue
            else :
                if ap < bp :
                    target = bp
                    dest = ap
                else :
                    target = ap
                    dest = bp

            union(dest, target)
            if len(ufa[dest]) == n :
                return timestamp

        return -1


