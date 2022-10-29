class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        '''
        Input/Output : List
        0 < = len(strs) < 10^5
        
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"] -> {b:1,a:1,t:1}, ["nat","tan"] -> {n:1,a:1,t:1}, ["ate","eat","tea"] -> {a:1,t:1:,e:1}]
        
        Input: str = [""]
        Output : [[""]]
        
        Input str = ["a"]
        Output : [["a"]]
        
        Dict = {{"abt" : ["bat"]}, {"ant" : ["nat","tan"]}, {aet : ["ate","eat","tea"]}}
        
        TC : O(n * mlog(m)) => m: maximum length of the word
        SC : O(n)
        '''

        
        list_dict = dict()
        for word in strs :
            key = tuple(sorted(word))
            if key in list_dict :
                list_dict[key].append(word)
            else :
                list_dict[key] = [word]
    
            
        return list(list_dict.values())
            
        
        
        
