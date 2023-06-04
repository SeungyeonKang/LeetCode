class Solution:
    # TC : O(n)
    # SC : O(n)
    def numRabbits(self, answers: List[int]) -> int:
        rmap = dict()
        rabbits = 0
        for rabbit in answers :
            if rabbit in rmap :
                quota = rmap[rabbit]
                quota -= 1
                if quota == 0 :
                    rmap.pop(rabbit)
                else :
                    rmap[rabbit] = quota
            else :
                rabbits += rabbit
                rabbits += 1
                if rabbit != 0 :
                    rmap[rabbit] = rabbit
        return rabbits
        
