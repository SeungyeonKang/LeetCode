class Solution {
    //TC : O(N^2)
    //SC : O(N^2)
    public List<String> letterCombinations(String digits) {
        // 컨셉 : 반환되는 스트링의 순서는 상관없음. cd = dc
        // 1. 결과 반환을 위한 리스트 생성, "" 로 초기화 항목 넣어줌
        // 2. 인풋으로 들어온 digit을 돌면서, 현재 result 리스트에 있는 모든 문자열에 한 문자씩 추가하여 넣어줌
        // ex ) 인풋이 "23인 경우"
        // [""] => [a", "b", "c"] => ["ad", "db", "cd", "ae", "be", "ce", "af", "bf", "cf"]
        
        List<String> result = new ArrayList<>();
        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        if(digits.length() == 0) return result;
        
        result.add("");
        
        for(int i=0;i<digits.length();i++){
            result = makeCombination(letter[digits.charAt(i)-'0'], result);
        }
        return result;
    }
    
    public List<String> makeCombination(String digitLetter, List<String> list) {
        List<String> result = new ArrayList<>();
        
        for(int i=0;i<digitLetter.length(); i++){
            for(String x : list) {
                result.add(x+digitLetter.charAt(i));
            }
        }
        return result;
    }
}
